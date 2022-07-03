package alone.juner.demo.sqlite.utils.docx;

import alone.juner.demo.sqlite.utils.docx.impl.WordConvertToHtmlServer;
import alone.juner.demo.sqlite.utils.docx.impl.WordTableServer;
import alone.juner.demo.sqlite.utils.file.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>Word 工具</h3><hr/>
 *
 * @author Juner
 * @version 0.0.37
 * @description
 * @date 2022年06月29日 14:07 星期三
 * @since JDK_1.8.0.271
 */
@Slf4j
public class WordUtils
        implements WordTableServer,
        WordConvertToHtmlServer
{
    private final static WordUtils INSTANCE = new WordUtils();

    /**
     * 返回 log 记录器
     * @return Logger
     */
    @Override
    public Logger getLoggerByWordTable() {
        return log;
    }

    private static WordUtils getInstance() {
        return INSTANCE;
    }

    /**
     * 创建普通模板文档
     *
     * @param templateFilePath 模版文件名
     * @param outputPath       输出文件名
     * @param map              数据
     */
    @SuppressWarnings("unused")
    public static void createDocument(
            String templateFilePath,
            String outputPath,
            Map<String, Object> map
    ) throws IOException {
        getInstance().usageTemplate(templateFilePath, outputPath, map);
    }

    /**
     * 创建扩展表格文档
     *
     * @param templateFilePath 模版文件名
     * @param outputPath       输出文件名
     * @param map              模版基本数据
     * @param extendMap        扩展数据
     */
    @SuppressWarnings("unused")
    public static void createTableWithExtend(
            String templateFilePath,
            String outputPath,
            Map<String, Object> map,
            LinkedHashMap<String, List<String>> extendMap
    ) throws IOException {
        getInstance().usageTemplate(templateFilePath, outputPath, map);

        Map<String, Integer> params = new HashMap<>();
        // 复制第一行，并随后插入新行，写入数据
        params.put(COPY_ROW_INDEX, 0);
        // 使用第一个表格
        params.put(TABLE_INDEX, 0);

        getInstance().extendData(outputPath, params, extendMap);
    }

    /**
     * 将 docx 转为 html
     * @param filePath 文件路径
     */
    public static void docxToHtml(String filePath) throws ParserConfigurationException, TransformerException, IOException {
        getInstance().doConvertToHTML(FileUtil.getMultipartFile(filePath));
    }

}

