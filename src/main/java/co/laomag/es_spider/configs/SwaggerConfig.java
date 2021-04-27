package co.laomag.es_spider.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                /* 添加你需要被扫描为swagger的相关包路径（通常配置主路径就可以了） */
                .apis(RequestHandlerSelectors.basePackage("co"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                /* 添加swagger的标题 */
                .title("爬虫平台")
                /* 添加swagger的描述信息 */
                .description("爬虫平台 API 接口文档")
                .version("1.0")
                .termsOfServiceUrl("")
                .version("1.0")
                .contact(new Contact("老马", "", "2695212419@qq.com"))
                .build();
    }

}
