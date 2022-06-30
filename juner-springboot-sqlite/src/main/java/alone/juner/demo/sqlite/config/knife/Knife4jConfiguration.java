package alone.juner.demo.sqlite.config.knife;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * <h3>Knife4j 接口文档</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 *              备注 @Profile({"dev", "test"}) 表明生效环境
 * @date 2022年06月29日 13:42 星期三
 * @since JDK_1.8.0.271
 */
@EnableKnife4j
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Autowired
    public Knife4jConfiguration(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title(ConfigParam.title)
                        .description(ConfigParam.description)
                        .termsOfServiceUrl(ConfigParam.terms_of_service_url)
                        .contact(ConfigParam.author)
                        .version(ConfigParam.version)
                        .build())
                .groupName(ConfigParam.group)
                .select()
                .apis(RequestHandlerSelectors.basePackage(ConfigParam.controller))
                .paths(PathSelectors.any())
                .build()
                .extensions(openApiExtensionResolver.buildExtensions(ConfigParam.group));;
        return docket;
    }

}
