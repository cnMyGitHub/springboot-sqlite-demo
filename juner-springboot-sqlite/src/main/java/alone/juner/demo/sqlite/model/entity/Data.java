package alone.juner.demo.sqlite.model.entity;

import alone.juner.demo.sqlite.common.validator.crud.Update;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * <h3>数据</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 19:50 星期日
 * @since JDK_1.8.0.271
 */
public class Data {

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
