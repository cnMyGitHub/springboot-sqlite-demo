package alone.juner.demo.sqlite.model.basic;

import javax.validation.constraints.Pattern;

/**
 * <h3>扩展信息</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 23:21 星期日
 * @since JDK_1.8.0.271
 */
public class ExpandInfo
        extends ControlInfo {

    @Pattern(regexp = "1|0", message = "用户名为5-24个数字或字母")
    public Byte isExpand;

    public String expand1;
    public String expand2;
    public String expand3;
    public String expand4;
    public String expand5;

}
