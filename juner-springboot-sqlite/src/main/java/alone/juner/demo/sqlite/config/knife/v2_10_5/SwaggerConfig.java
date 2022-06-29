//package alone.juner.demo.sqlite.config.knife.backup;
//
//import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.ParameterBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.schema.ModelRef;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Parameter;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * <h3>例 2</h3><hr/>
// *
// * @author Juner
// * @version 0.0.1
// * @description
// *              http://localhost:18080/doc.html
// *              备注 @EnableSwagger2WebMvc -> springfox-swagger2 使用 2.10.5
// * @date 2022年06月29日 13:07 星期三
// * @since JDK_1.8.0.271
// */
//@EnableKnife4j
//@Configuration
//@EnableSwagger2WebMvc
//@Import(BeanValidatorPluginsConfiguration.class)
//public class SwaggerConfig {
//
//    @Bean
//    public Docket createRestApi(){
//        // 添加请求参数，我们这里把token作为请求头部参数传入后端
//        ParameterBuilder parameterBuilder = new ParameterBuilder();
//        List<Parameter> parameters = new ArrayList<Parameter>();
//        parameterBuilder.name("token").description("令牌")
//                .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        parameters.add(parameterBuilder.build());
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .globalOperationParameters(parameters);
//    }
//
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder().build();
//    }
//
//}
//
