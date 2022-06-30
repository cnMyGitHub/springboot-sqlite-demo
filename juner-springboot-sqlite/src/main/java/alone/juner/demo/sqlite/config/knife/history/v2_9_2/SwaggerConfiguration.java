//package alone.juner.demo.sqlite.config.knife.history.v2_9_2;
//
//import io.swagger.annotations.ApiOperation;
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
// * <h3>例 4</h3><hr/>
// *
// * @author Juner
// * @version 0.0.1
// * @description
// *              备注 @EnableSwagger2WebMvc -> springfox-swagger2 使用 2.9.2
// * @date 2022年06月27日 14:45 星期一
// * @since JDK_1.8.0.271
// */
//@Configuration
//@EnableSwagger2
//public class SwaggerConfiguration {
//
//
//    @Bean(value = "defaultApi2")
//    public Docket defaultApi2() {
//        Docket docket=new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("低版本版本")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("alone.juner.demo.sqlite.controller"))
////                .apis(RequestHandlerSelectors.basePackage("com.xiaominfo.knife4j.demo.web"))
////                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build();
//        return docket;
//    }
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("swagger-bootstrap-ui-demo RESTful APIs")
//                .description("# swagger-bootstrap-ui-demo RESTful APIs")
//                .termsOfServiceUrl("http://www.xx.com/")
////                .contact("xx@qq.com")
//                .version("1.0")
//                .build();
//    }
//
//}
//
////@Configuration
////@EnableSwagger2
//////@EnableSwagger2WebMvc
////@EnableKnife4j
////@ConditionalOnExpression("${knife4j.enable}") //开启访问接口文档的权限  **knife4j.enable是在yml配置文件中配置为true**
////public class SwaggerConfiguration {
////
////    @Bean
////    public Docket createRestApi() {
////        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
////                .apis(RequestHandlerSelectors.basePackage("alone.juner.demo.sqlite.controller")).paths(PathSelectors.any()).build();
////    }
////
////    private ApiInfo apiInfo() {
////        return new ApiInfoBuilder()
////                .title("Spring Boot中使用Swagger2构建RESTful APIs(带认证）")
////                .description("更多Spring Boot相关文章请关注：https://blog.csdn.net/elvishehai")
////                .termsOfServiceUrl("https://blog.csdn.net/elvishehai")
////                .version("1.0")
////                .build();
////    }
////
////}
//
////@Configuration
////@EnableSwagger2
////@EnableSwaggerBootstrapUi
////@Import(BeanValidatorPluginsConfiguration.class)
////public class SwaggerConfiguration {
////
////    private final TypeResolver typeResolver;
////
////    @Autowired
////    public SwaggerConfiguration(TypeResolver typeResolver) {
////        this.typeResolver = typeResolver;
////    }
////
////    /*@Bean
////    public UiConfiguration uiConfiguration(){
////        return UiConfigurationBuilder.builder().supportedSubmitMethods(new String[]{})
////                .displayOperationId(true)
////                .build();
////    }*/
////
////
////    @Bean(value = "defaultApi")
////    public Docket defaultApi() {
////        ParameterBuilder parameterBuilder=new ParameterBuilder();
////        List<Parameter> parameters= Lists.newArrayList();
////        parameterBuilder.name("token").description("token令牌").modelRef(new ModelRef("String"))
////                .parameterType("header")
////                .required(true).build();
////        parameters.add(parameterBuilder.build());
////
////        Docket docket=new Docket(DocumentationType.SWAGGER_2)
////                .apiInfo(apiInfo())
////                .groupName("默认接口")
////                .select()
////                .apis(RequestHandlerSelectors.basePackage("com.swagger.bootstrap.ui.demo.controller"))
////                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
////                .paths(PathSelectors.any())
////                .build().globalOperationParameters(parameters)
////                .securityContexts(Lists.newArrayList(securityContext())).securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey()));
////        return docket;
////    }
////    @Bean(value = "groupRestApi")
////    public Docket groupRestApi() {
////        List<ResolvedType> list=Lists.newArrayList();
////
////        //SpringAddtionalModel springAddtionalModel= springAddtionalModelService.scan("com.swagger.bootstrap.ui.demo.extend");
////        return new Docket(DocumentationType.SWAGGER_2)
////                .apiInfo(groupApiInfo())
////                .groupName("分组接口")
////                .select()
////                .apis(RequestHandlerSelectors.basePackage("com.swagger.bootstrap.ui.demo.group"))
////                .paths(PathSelectors.any())
////                .build()
////                .additionalModels(typeResolver.resolve(DeveloperApiInfo.class)).securityContexts(Lists.newArrayList(securityContext(),securityContext1())).securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey(),apiKey1()));
////    }
////
////    private ApiInfo groupApiInfo(){
////        DeveloperApiInfoExtension apiInfoExtension=new DeveloperApiInfoExtension();
////
////        apiInfoExtension.addDeveloper(new DeveloperApiInfo("张三","zhangsan@163.com","Java"))
////                .addDeveloper(new DeveloperApiInfo("李四","lisi@163.com","Java"));
////
////
////        return new ApiInfoBuilder()
////                .title("swagger-bootstrap-ui很棒~~~！！！")
////                .description("<div style='font-size:14px;color:red;'>swagger-bootstrap-ui-demo RESTful APIs</div>")
////                .termsOfServiceUrl("http://www.group.com/")
////                .contact("group@qq.com")
////                .version("1.0")
////                .extensions(Lists.newArrayList(apiInfoExtension))
////                .build();
////    }
////
////    private ApiInfo apiInfo() {
////        return new ApiInfoBuilder()
////                .title("swagger-bootstrap-ui-demo RESTful APIs")
////                .description("# swagger-bootstrap-ui-demo RESTful APIs")
////                .termsOfServiceUrl("http://www.xx.com/")
////                .contact("xx@qq.com")
////                .version("1.0")
////                .build();
////    }
////
////    private ApiKey apiKey() {
////        return new ApiKey("BearerToken", "Authorization", "header");
////    }
////    private ApiKey apiKey1() {
////        return new ApiKey("BearerToken1", "Authorization-x", "header");
////    }
////
////    private SecurityContext securityContext() {
////        return SecurityContext.builder()
////                .securityReferences(defaultAuth())
////                .forPaths(PathSelectors.regex("/.*"))
////                .build();
////    }
////    private SecurityContext securityContext1() {
////        return SecurityContext.builder()
////                .securityReferences(defaultAuth1())
////                .forPaths(PathSelectors.regex("/.*"))
////                .build();
////    }
////
////    List<SecurityReference> defaultAuth() {
////        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
////        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
////        authorizationScopes[0] = authorizationScope;
////        return Lists.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
////    }
////    List<SecurityReference> defaultAuth1() {
////        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
////        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
////        authorizationScopes[0] = authorizationScope;
////        return Lists.newArrayList(new SecurityReference("BearerToken1", authorizationScopes));
////    }
////
////}