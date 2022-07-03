package alone.juner.demo.sqlite.utils.yaml;

import alone.juner.demo.sqlite.utils.application.ApplicationContextUtil;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.reader.UnicodeReader;

import java.io.*;
import java.util.*;

/**
 * <h3>yaml配置读取</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年07月01日 15:28 星期五
 * @since JDK_1.8.0.271
 */
@Slf4j
@Builder
@Service
public class YamlUtils {

    public static void main(String[] args) {
        Map<String, Object> map = YamlUtils.builder().build().getChildByAppointKey(null, "custom");
        System.out.println(map.get("node"));
        System.out.println(((Map<String, String>) map.get("node")).get("name"));
    }

    /**
     * 默认yml文件地址
     */
    private static final String BOOTSTRAP_FILE = "classpath:bootstrap.yml";

    /**
     * 缓存
     */
    private static final Map<String, Map<String, Object>> TEMP = new HashMap<>();


    /**
     * 读取指定文件下指定key下所有子属性
     *
     * @param appointKey 指定key
     * @param path       指定文件
     * @return 子属性集合
     */
    public Map<String, Object> getChildByAppointKey(String path, String appointKey) {
        if (TEMP.containsKey(appointKey)) {
            return TEMP.get(appointKey);
        }
        if (path == null) {
            path = BOOTSTRAP_FILE;
        }
        HashMap<String, Object> result = new HashMap<>(8);
        InputStream in = null;
        try {
            File file = ResourceUtils.getFile(path);
            in = new BufferedInputStream(new FileInputStream(file));
            Yaml props = new Yaml();
            Object obj = props.loadAs(in, Map.class);
            Map<String, Object> param = (Map<String, Object>) obj;

            for (Map.Entry<String, Object> entry : param.entrySet()) {
                String key = entry.getKey();
                Object val = entry.getValue();
                if (appointKey.equals(key)) {
                    if (val instanceof Map) {
                        result.putAll((Map<String, String>) val);
                    } else {
                        result.put(key, val.toString());
                    }
                }

            }
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        TEMP.put(appointKey, result);
        return result;
    }

}
