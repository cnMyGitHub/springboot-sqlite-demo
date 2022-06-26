package alone.juner.demo.sqlite.model.basic;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <h3>基本信息</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description 时间及变更者
 * @date 2022年06月26日 19:50 星期日
 * @since JDK_1.8.0.271
 */
public class BasicInfo {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public String createTime;

    public String createBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public String modifyTime;

    public String modifyBy;

}