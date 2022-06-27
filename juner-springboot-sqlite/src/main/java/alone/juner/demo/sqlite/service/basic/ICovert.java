package alone.juner.demo.sqlite.service.basic;

import org.mapstruct.InheritInverseConfiguration;

import java.util.List;

/**
 * <h3>顶级转换类</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 *      使用方法： 继承并声明
 *      -> ICovert INSTANCE = Mappers.getMapper({Object}.class);
 *      -> @Mapping(source = "orders", target = "orderItems")
 * @date 2022年06月27日 13:03 星期一
 * @since JDK_1.8.0.271
 */
public interface ICovert<BO, Entity, VO> {

    /**
     * Entity 转换为 VO
     * @param source Entity
     * @return VO
     */
    VO toConvertVO(Entity source);

    /**
     * BO 转换为 Entity
     * @param source BO
     * @return Entity
     */
    Entity toConvert(BO source);

//    /**
//     * Entity 批量转换为 VO类
//     * @param source List Entity
//     * @return List VO
//     */
//    List<VO> toConvertVOList(List<Entity> source);

//    /**
//     * TODO
//     * @param customer Entity
//     * @return VO
//     */
//    @InheritInverseConfiguration
//    VO fromCustomer(Entity customer);

}
