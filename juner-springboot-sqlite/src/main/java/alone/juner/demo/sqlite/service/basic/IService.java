package alone.juner.demo.sqlite.service.basic;

import alone.juner.demo.sqlite.mapper.basic.IMapper;
import alone.juner.demo.sqlite.model.basic.PageHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * <h3>顶级服务</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 19:49 星期日
 * @since JDK_1.8.0.271
 */
public interface IService<BO, Entity, VO> {


    /**
     * 创建
     *
     * @param data 数据模型
     */
    void create(BO data);

    /**
     * 删除（逻辑）
     *
     * @param id 数据模型 ID
     */
    void remove(Long id);

    /**
     * 更新
     *
     * @param data 数据模型
     */
    void update(BO data);

    /**
     * 查找数据
     *
     * @param data       查找条件
     * @param pageHelper 分页情况
     * @return 数据列
     */
    List<VO> search(BO data, PageHelper pageHelper);

    /**
     * 查找符合条件的个数
     *
     * @param data       查找条件
     * @param pageHelper 分页情况
     * @return 个数
     */
    Long count(BO data, PageHelper pageHelper);

    /**
     * 将对象转换成 JSON 字符串
     *
     * @param content 对象
     * @return JSON字符串
     */
    default String readToJSON(Object content) throws JsonProcessingException {
        String jsonString = null;
        ObjectMapper objectMapper = new ObjectMapper();
        jsonString = objectMapper.writeValueAsString(content);
        return jsonString;
    }

    /**
     * 检查是否存在该数据
     *
     * @param mapper 数据访问层 Mapper
     * @param id     唯一 ID
     * @param <T>    数据访问层 子类 Mapper
     */
    default <T extends IMapper> Long checkIsExist(T mapper, Long id) {
        if (mapper.exist(id) == 0) {
            throw new RuntimeException("数据不存在，请查证后再进行操作。");
        }
        return id;
    }

}
