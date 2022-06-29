package alone.juner.demo.sqlite.config.cors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <h3></h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月27日 15:12 星期一
 * @since JDK_1.8.0.271
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(
        prefix = "free-reign.cors",
        ignoreInvalidFields = true,
        ignoreUnknownFields = false
)
public class CorsProperties {
    /** 允许跨域访问的路径 */
    private String mapping = "/**";
    /** 允许跨域访问的源 */
    private String allowedOriginal = "*";
    /** 允许请求方法 */
    private String allowedMethods = "POST,GET,PUT,OPTIONS,DELETE";
    /** 预检间隔时间 */
    private Integer maxAge = 16800;
    /** 允许头部设置 */
    private String allowedHeaders = "*";
    /** 是否发送cookie */
    private boolean allowCredentials = Boolean.TRUE;

    public String[] getAllowedMethods() {
        return allowedMethods.split(",\\s*");
    }
}
