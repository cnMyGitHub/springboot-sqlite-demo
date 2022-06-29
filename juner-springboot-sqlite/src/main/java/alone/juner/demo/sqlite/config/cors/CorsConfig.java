//package alone.juner.demo.sqlite.config.cors;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * <h3></h3><hr/>
// *
// * @author Juner
// * @version 0.0.1
// * @description
// * @date 2022年06月27日 15:12 星期一
// * @since JDK_1.8.0.271
// */
//@Slf4j
//@Configuration
//@EnableConfigurationProperties({CorsProperties.class})
//public class CorsConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private CorsProperties corsProperties;
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping(corsProperties.getMapping()) // 允许跨域访问的路径
//                .allowedOrigins(corsProperties.getAllowedOriginal()) // 允许跨域访问的源
//                .allowedMethods(corsProperties.getAllowedMethods()) // 允许请求方法
//                .maxAge(corsProperties.getMaxAge())	// 预检间隔时间
//                .allowedHeaders(corsProperties.getAllowedHeaders()) // 允许头部设置
//                .allowCredentials(corsProperties.isAllowCredentials()); // 是否发送cookie
//        log.info(registry.toString());
//    }
//
//}
