package alone.juner.demo.sqlite.utils.docx.impl;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * <h3>Word 转换为 HTML 服务</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年07月01日 18:09 星期五
 * @since JDK_1.8.0.271
 */
public interface WordConvertToHtmlServer
        extends WordInfo {

    /**
     * 获取 logger 日志对象
     *
     * @return Logger
     */
    Logger getLoggerByWordTable();

    /**
     * 执行word转换html标签
     *
     * @param file word文件
     * @return html标签
     */
    default String doConvertToHTML(MultipartFile file) throws IOException, TransformerException, ParserConfigurationException {
        if (file == null) {
            throw new IOException("上传文件错误");
        }
        String fileNameFullPath = file.getOriginalFilename();
        getLoggerByWordTable().info("WordConvertToHtml.doConvertToHTML.fileNameFullPath ==> {}", fileNameFullPath);
        assert fileNameFullPath != null;
        String fileSuffix = fileNameFullPath.substring(fileNameFullPath.lastIndexOf("."));
        String fileName = fileNameFullPath.substring(0, fileNameFullPath.lastIndexOf("."));
        InputStream inputStream = file.getInputStream();
        String content;
        if (DOC_SUFFIX.equals(fileSuffix)) {
            content = word2003ToHtml(inputStream, fileName);
        } else if (DOCX_SUFFIX.equals(fileSuffix)) {
            content = word2007ToHtml(inputStream, fileName);
        } else {
            throw new IOException("上传文件格式错误");
        }
        getLoggerByWordTable().info("WordConvertToHtml.doConvertToHTML.content ==> {}", content);
        return content;
    }

    /**
     * doc-2003版转换
     *
     * @param inputStream 导入文件流、原word文档
     * @param wordName    文件名称
     * @return html标签
     * @throws IOException                  io异常
     * @throws TransformerException         文件转换异常
     * @throws ParserConfigurationException 解析异常
     */
    default String word2003ToHtml(InputStream inputStream, String wordName) throws IOException, TransformerException, ParserConfigurationException {
        String htmlPath = TEMP_HTML_PATH + File.separator + wordName + "_show_" + System.currentTimeMillis() + File.separator;
        String htmlName = wordName + HTML_SUFFIX;
        final String imagePath = htmlPath + "image" + File.separator;

        //判断html文件是否存在
        File htmlFile = new File(htmlPath + htmlName);

        HWPFDocument wordDocument = new HWPFDocument(inputStream);
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        //设置图片存放的位置
        wordToHtmlConverter.setPicturesManager(new PicturesManager() {
            @Override
            public String savePicture(byte[] content, org.apache.poi.hwpf.usermodel.PictureType pictureType, String suggestedName, float widthInches, float heightInches) {
                File imgPath = new File(imagePath);
                //图片目录不存在则创建
                if (!imgPath.exists()) {
                    imgPath.mkdirs();
                }
                File file = new File(imagePath + suggestedName);
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(content);
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //图片在html文件上的路径 相对路径
                return "image/" + suggestedName;
            }
        });

        //解析word文档
        wordToHtmlConverter.processDocument(wordDocument);
        Document htmlDocument = wordToHtmlConverter.getDocument();

        //生成html文件上级文件夹
        File folder = new File(htmlPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        //生成html文件地址
        OutputStream outStream = new FileOutputStream(htmlFile);

        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(outStream);

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer serializer = factory.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, HTML_LABEL_ENCODE);
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");

        serializer.transform(domSource, streamResult);

        outStream.close();
        return analysisLabel(htmlFile);
    }


    /**
     * docx-2007以上版转换
     *
     * @param inputStream 导入文件流、原word文档
     * @param wordName    文件名称
     * @return html标签
     * @throws IOException 异常
     */
    default String word2007ToHtml(InputStream inputStream, String wordName) throws IOException {
        String htmlPath = TEMP_HTML_PATH + File.separator + wordName + "_show_" + System.currentTimeMillis() + File.separator;
        String htmlName = wordName + HTML_SUFFIX;
        String imagePath = htmlPath + "image" + File.separator;

        //判断html文件是否存在
        File htmlFile = new File(htmlPath + htmlName);

        //word文件
        // 1) 加载word文档生成 XWPFDocument对象
        XWPFDocument document = new XWPFDocument(inputStream);

        // 2) 解析 XHTML配置 (这里设置IURIResolver来设置图片存放的目录)
        File imgFolder = new File(imagePath);
        XHTMLOptions options = XHTMLOptions.create();
        options.setExtractor(new FileImageExtractor(imgFolder));
        //html中图片的路径 相对路径
        options.URIResolver(new BasicURIResolver("image"));
        options.setIgnoreStylesIfUnused(false);
        options.setFragment(true);

        // 3) 将 XWPFDocument转换成XHTML
        //生成html文件上级文件夹
        File folder = new File(htmlPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        OutputStream out = new FileOutputStream(htmlFile);
        XHTMLConverter.getInstance().convert(document, out, options);

        return analysisLabel(htmlFile);
    }

    /**
     * 标签转换
     *
     * @param htmlFile html文件
     * @return html标签
     * @throws IOException 读取文件流异常
     */
    default String analysisLabel(File htmlFile) throws IOException {
        //打印html标签
        FileInputStream htmlInputStream = new FileInputStream(htmlFile);
        InputStreamReader inputStreamReader = new InputStreamReader(htmlInputStream, HTML_LABEL_ENCODE);
        StringBuilder builder = new StringBuilder();
        int temp;
        while ((temp = inputStreamReader.read()) != -1) {
            builder.append((char) temp);
        }
        String content = builder.toString();
        // 删除缓存文件
        boolean delete = htmlFile.delete();
        // 2007版 去除div距顶部距离
        content = content.replaceFirst("margin-bottom:89.0pt;", "");
        // 2003版 去除body距顶部距离
        content = content.replaceFirst("<body", "<body style='margin-top:0;'");
        return content;
    }

}
