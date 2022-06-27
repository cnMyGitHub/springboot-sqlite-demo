package alone.juner.demo.sqlite.mapper.basic;

import alone.juner.demo.sqlite.model.basic.PageHelper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>顶级数据访问</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月27日 9:50 星期一
 * @since JDK_1.8.0.271
 */
public interface IMapper<Entity, VO> {

    /**
     * 创建
     * @param record 数据模型
     */
    void create(@Param("record") Entity record);

    /**
     * 删除（逻辑）
     * @param id 数据模型 ID
     */
    void remove(Long id);

    /**
     * 更新
     * @param record 数据模型
     */
    void update(@Param("record") Entity record);

    /**
     * 查找数据
     * @param record 查找条件
     * @param pageHelper 分页情况
     * @return 数据列
     */
    List<VO> search(@Param("record") Entity record, @Param("pager") PageHelper pageHelper);

    /**
     * 查找符合条件的个数
     * @param record 查找条件
     * @param pageHelper 分页情况
     * @return 个数
     */
    Long count(@Param("record") Entity record, @Param("pager") PageHelper pageHelper);

    /**
     * 查找符合条件的个数
     * @param id 查找的数据 ID
     * @return 个数
     */
    Long exist(Long id);

}
