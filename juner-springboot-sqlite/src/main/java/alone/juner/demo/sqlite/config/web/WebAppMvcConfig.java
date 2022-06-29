//package alone.juner.demo.sqlite.config.web;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * <h3></h3><hr/>
// *
// * @author Juner
// * @version 0.0.1
// * @description
// * @date 2022年06月27日 16:40 星期一
// * @since JDK_1.8.0.271
// */
//@Configuration
//public class WebAppMvcConfig implements WebMvcConfigurer {
//
//    /**
//     * 注册自定义的显示 ResponseResult 注解的拦截器
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(new ResponseResultInterceptor())
////                // 拦截配置
////                .addPathPatterns("/**")
////                // 排除配置
////                .excludePathPatterns("/error", "/login**");
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//
//        /** 配置knife4j 显示文档 */
//        registry.addResourceHandler("doc.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        /**
//         * 配置swagger-ui显示文档
//         */
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        /** 公共部分内容 */
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//}
