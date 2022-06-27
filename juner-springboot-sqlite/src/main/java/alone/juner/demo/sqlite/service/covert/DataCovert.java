package alone.juner.demo.sqlite.service.covert;

import alone.juner.demo.sqlite.model.bo.DataBO;
import alone.juner.demo.sqlite.model.entity.Data;
import alone.juner.demo.sqlite.model.vo.DataTreeVO;
import alone.juner.demo.sqlite.service.basic.ICovert;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

/**
 * <h3>数据转换</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description BO、Entity、VO 间转换
 * @date 2022年06月27日 13:07 星期一
 * @since JDK_1.8.0.271
 */
@Mapper(mappingControl = DeepClone.class)
public interface DataCovert
        extends ICovert<DataBO, Data, DataTreeVO> {

    DataCovert INSTANCE = Mappers.getMapper( DataCovert.class );

}
