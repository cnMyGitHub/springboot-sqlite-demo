//package alone.juner.demo.sqlite.config.knife.backup;
//
//import alone.juner.demo.sqlite.config.knife.ConfigParam;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * <h3>Swagger 简单配置</h3><hr/>
// *
// * @author Juner
// * @version 0.0.1
// * @description 备注 @EnableSwagger2WebMvc -> springfox-swagger2 使用 2.9.2
// * @date 2022年06月29日 13:28 星期三
// * @since JDK_1.8.0.271
// */
////@Configuration
////@EnableSwagger2
//public class SwaggerConfig2{
//
//    @Bean
//    public Docket getDocket(){
//        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
//        apiInfoBuilder.title("后端接口说明文档")
//                .description("此文档详细说明了后端接口规范")
//                .version("v 2.0.1")
//                .contact(new Contact("dev","www.google.com","google@dev.com"));
//        ApiInfo apiInfo = apiInfoBuilder.build();
//
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(ConfigParam.controller))
//                .paths(PathSelectors.any())
//                .build();
//        return docket;
//    }
//}
