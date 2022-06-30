package alone.juner.demo.sqlite.model.basic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * <h3>控制开关信息</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 23:22 星期日
 * @since JDK_1.8.0.271
 */
@ApiModel("控制开关信息")
public class ControlInfo
        extends BasicInfo {

    @ApiModelProperty(value = "是否删除？")
    @Size(min = 0, max = 1, message = "")
    public Byte isDelete;

    @ApiModelProperty(value = "是否显示？")
    @Min(value = 0,message = "最小为0")
    @Max(value = 1,message = "最大为1")
    public Byte isDisplay;

}
