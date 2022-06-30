package alone.juner.demo.sqlite.config.cors.impl;

import alone.juner.demo.sqlite.config.cors.CorsProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <h3> CORS 低版本 2.4以下 </h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description SpringBoot 低于 2.4 版本
 * @date 2022年06月30日 15:26 星期四
 * @since JDK_1.8.0.271
 */
@Slf4j
public abstract class CorsLowVersion
        implements WebMvcConfigurer {

    @Autowired
    private CorsProperties corsProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry
                // 允许跨域访问的路径
                .addMapping(corsProperties.getMapping())

                // 允许跨域访问的源
                .allowedOrigins(corsProperties.getAllowedOriginal())

                // 允许请求方法
                .allowedMethods(corsProperties.getAllowedMethods())

                // 预检间隔时间
                .maxAge(corsProperties.getMaxAge())

                // 允许头部设置
                .allowedHeaders(corsProperties.getAllowedHeaders())

                // 是否发送cookie
                .allowCredentials(corsProperties.isAllowCredentials());

        log.info(registry.toString());
    }

}
