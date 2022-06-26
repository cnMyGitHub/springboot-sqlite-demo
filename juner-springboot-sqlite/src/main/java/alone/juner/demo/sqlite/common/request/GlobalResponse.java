package alone.juner.demo.sqlite.common.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <h3>全局响应</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 19:24 星期日
 * @since JDK_1.8.0.271
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class GlobalResponse<T> {

    private Integer code;
    private String message;
    private Long page;
    private Long limit;
    private Long totalCount;
    private Long totalPages;
    private T data;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date now = new Date();
    private String useTime;

    private static <T> GlobalResponse<T> builder() {
        return new GlobalResponse<>();
    }
    public static <T> GlobalResponse of(T data) {
        return builder().setData(data);
    }
    public static GlobalResponse<Object> success() {
        return builder().setCode(200).setMessage("请求成功");
    }
    public static GlobalResponse<Object> error() {
        return error("系统异常，请联系管理员");
    }
    public static GlobalResponse<Object> error(String message) {
        return builder().setCode(500).setMessage(message);
    }
    public static GlobalResponse<Object> disable() {
        return builder().setCode(401).setMessage("功能暂未开放");
    }

}

