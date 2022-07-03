package alone.juner.demo.sqlite.utils.file;

import alone.juner.demo.sqlite.utils.file.impl.FileConvertMultipartFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * <h3>文件工具</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年07月01日 18:34 星期五
 * @since JDK_1.8.0.271
 */
public class FileUtil
    implements FileConvertMultipartFile
{

    private final static FileUtil INSTANCE = new FileUtil();

    private static FileUtil getInstance() {
        return INSTANCE;
    }

    /**
     * 获取一个 MultipartFile 的文件对象
     * @param filePath 文件路径
     * @return MultipartFile
     */
    public static MultipartFile getMultipartFile(String filePath) {
        return getInstance().createMultipartFile(filePath);
    }

}
