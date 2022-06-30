package alone.juner.demo.sqlite.config.cors;

import alone.juner.demo.sqlite.config.cors.impl.CorsHightVersion;
import alone.juner.demo.sqlite.config.cors.impl.CorsLowVersion;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <h3></h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月27日 15:12 星期一
 * @since JDK_1.8.0.271
 */
@Configuration
@EnableConfigurationProperties({CorsProperties.class})
public class CorsConfig extends CorsHightVersion {

}
