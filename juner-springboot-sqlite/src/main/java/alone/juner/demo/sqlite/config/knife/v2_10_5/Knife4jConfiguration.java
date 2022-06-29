//package alone.juner.demo.sqlite.config.knife.v2_10_5;
//
//import alone.juner.demo.sqlite.config.knife.ConfigParam;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//
///**
// * <h3>例 1</h3><hr/>
// *
// * @author Juner
// * @version 0.0.1
// * @description
// *              http://localhost:18080/doc.html
// *              备注 @EnableSwagger2WebMvc -> springfox-swagger2 使用 2.10.5
// * @date 2022年06月27日 14:47 星期一
// * @since JDK_1.8.0.271
// */
//@Configuration
//@EnableSwagger2WebMvc
//public class Knife4jConfiguration {
//
//    @Bean(value = "defaultApi2")
//    public Docket defaultApi2() {
//        Docket docket=new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(new ApiInfoBuilder()
//                        //.title("swagger-bootstrap-ui-demo RESTful APIs")
//                        .description("# swagger-bootstrap-ui-demo RESTful APIs")
//                        .termsOfServiceUrl("http://www.xx.com/")
////                        .contact("xx@qq.com")
//                        .version("1.0")
//                        .build())
//                //分组名称
//                .groupName("2.X版本")
//                .select()
//                //这里指定Controller扫描包路径
//                .apis(RequestHandlerSelectors.basePackage(ConfigParam.controller))
//                .paths(PathSelectors.any())
//                .build();
//        return docket;
//    }
//}
