package alone.juner.demo.sqlite.utils.file.impl;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * <h3>File 转换 MultipartFile 服务 </h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年07月01日 18:38 星期五
 * @since JDK_1.8.0.271
 */
public interface FileConvertMultipartFile {

    /**
     * File 转换为 MultipartFile
     * @param filePath 文件路径
     * @return MultipartFile
     */
    default MultipartFile createMultipartFile(String filePath) {
        FileItem fileItem = createFileItem(filePath);
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        return multipartFile;
    }

    /**
     * File 转换为 FileItem
     * @param filePath 文件路径
     * @return FileItem
     */
    default FileItem createFileItem(String filePath) {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        String textFieldName = "textField";
        int num = filePath.lastIndexOf(".");
        String extFile = filePath.substring(num);
        FileItem item = factory.createItem(textFieldName, "text/plain", true, "MyFileName");
        File newfile = new File(filePath);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try {
            FileInputStream fis = new FileInputStream(newfile);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

}
