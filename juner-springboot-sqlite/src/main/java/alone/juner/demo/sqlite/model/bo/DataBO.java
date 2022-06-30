package alone.juner.demo.sqlite.model.bo;

import alone.juner.demo.sqlite.common.validator.crud.Update;
import alone.juner.demo.sqlite.model.basic.ControlInfo;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * <h3> (TODO) 请求参数数据</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月27日 8:26 星期一
 * @since JDK_1.8.0.271
 */
@ApiModel("请求参数")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class DataBO
    extends ControlInfo
{

    @NotNull(message = "主键不得为空", groups = Update.class)
    public Long id;

    @NotEmpty(message = "key 不能为空")
    public String key;
    public String value;
    public String code;
    public String remark;
    public Object parent;

    public BigDecimal nNumber;
    public BigDecimal nScore;

    public String cMode;
    public Integer cOrder;
    public String cGroup;
    public String cChildrenInfo;
    public String cExpandInfo;
    public String cVersion;
    public Byte cStatus;

}
