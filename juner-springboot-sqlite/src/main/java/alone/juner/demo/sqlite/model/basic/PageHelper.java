package alone.juner.demo.sqlite.model.basic;

import alone.juner.demo.sqlite.common.validator.custom.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <h3>分页助手</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description 链式编程
 * @date 2022年06月26日 23:25 星期日
 * @since JDK_1.8.0.271
 */
@ApiModel("分页信息")
@Getter
@Setter
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PageHelper {

    @ApiModelProperty(
            value = "查询条数",
            name = "limit"
//            ,allowableValues = "32",
//            access = "1",
//            notes = "用户的id",
//            dataType = "int",
//            required = false,
//            position = 1,
//            hidden = true,
//            example = "1",
//            readOnly = false,
//            reference = "id",
//            allowEmptyValue = false
    )
    private Long limit;
    @ApiModelProperty(value = "分页号")
    private Long page;

    @ApiModelProperty(value = "总条数")
    private Long totalCount;
    @ApiModelProperty(value = "总页数")
    private Long totalPages;

    @ApiModelProperty(value = "自定义字段")
    private String filed;

    @ApiModelProperty(value = "自定义排序类型")
    @Check(regex = "1|-1", field = "order")
    private Byte order;

    public Number getPage() {
        if (null != this.page) {
            return (this.page - 1) * limit;
        }
        return null;
    }

    public Number getTotalPages() {
        if (null != this.totalPages) {
            return this.totalPages % this.limit == 0
                    ? this.totalPages / this.limit
                    : (this.totalPages / this.limit) + 1;
        }
        return null;
    }
}
