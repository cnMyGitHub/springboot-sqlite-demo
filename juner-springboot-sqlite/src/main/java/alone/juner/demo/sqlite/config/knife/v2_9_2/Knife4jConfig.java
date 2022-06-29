//package alone.juner.demo.sqlite.config.knife.v2_9_2;
//
//import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * <h3>例 3</h3><hr/>
// *
// * @author Juner
// * @version 0.0.1
// * @description
// *              备注 @EnableSwagger2WebMvc -> springfox-swagger2 使用 2.9.2
// * @date 2022年06月27日 16:35 星期一
// * @since JDK_1.8.0.271
// */
//@EnableSwagger2
//@EnableKnife4j
//@Configuration
//public class Knife4jConfig {
//
//    @Bean(value = "defaultApi2")
//    public Docket defaultApi2() {
//        Docket docket=new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                //分组名称
//                .groupName("测试分组")
//                .select()
//                //这里指定Controller扫描包路径
//                .apis(RequestHandlerSelectors.basePackage("com.xiaominfo.knife4j.controller"))
//                .paths(PathSelectors.any())
//                .build();
//        return docket;
//    }
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("swagger-bootstrap-ui很棒~~~！！！")
//                .description("swagger-bootstrap-ui-demo RESTful APIs")
//                .termsOfServiceUrl("http://www.group.com/")
////                .contact("group@qq.com")
//                .version("1.0")
//                .build();
//    }
//}
