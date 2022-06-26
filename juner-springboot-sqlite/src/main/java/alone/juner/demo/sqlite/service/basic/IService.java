package alone.juner.demo.sqlite.service.basic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <h3>顶级服务</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 19:49 星期日
 * @since JDK_1.8.0.271
 */
public interface IService<T> {

    /**
     * 将对象转换成 JSON 字符串
     * @param content 对象
     * @return JSON字符串
     */
    default String read(T content) throws JsonProcessingException {
        String jsonString = null;
        ObjectMapper objectMapper = new ObjectMapper();
        jsonString = objectMapper.writeValueAsString(content);
        return jsonString;
    }

}
