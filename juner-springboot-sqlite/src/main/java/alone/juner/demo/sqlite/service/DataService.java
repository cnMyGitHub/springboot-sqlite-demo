package alone.juner.demo.sqlite.service;

import alone.juner.demo.sqlite.model.bo.DataBO;
import alone.juner.demo.sqlite.model.entity.Data;
import alone.juner.demo.sqlite.model.vo.DataTreeVO;
import alone.juner.demo.sqlite.service.basic.IService;

/**
 * <h3>数据服务接口</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 19:49 星期日
 * @since JDK_1.8.0.271
 */
public interface DataService
        extends IService<DataBO, Data, DataTreeVO>
{

}
