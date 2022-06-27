package alone.juner.demo.sqlite.mapper;

import alone.juner.demo.sqlite.mapper.basic.IMapper;
import alone.juner.demo.sqlite.model.entity.Data;
import alone.juner.demo.sqlite.model.vo.DataTreeVO;
import org.springframework.stereotype.Repository;

/**
 * <h3>数据访问</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 20:09 星期日
 * @since JDK_1.8.0.271
 */
@Repository
public interface DataMapper
        extends IMapper<Data, DataTreeVO>
{

}
