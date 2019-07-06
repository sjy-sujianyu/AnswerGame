package org.stream.answerduel.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述：SwaggerUI配置类
 *
 * @Auther: 梁展鹏
 * @Date: 2018/8/2 10:21
 */
@EnableSwagger2
@SpringBootConfiguration
public class SwaggerUIConfig {

    /**
     * 是否启动文档标识
     */
    private Boolean enableSwaggerUI = Boolean.FALSE;

    private Environment environment;

    /**
     * 功能描述：注入环境变量
     *
     * @param environment
     * @Auther: 梁展鹏
     * @Date: 2018/8/2 10:21
     */
    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;

        /* 通过启动的环境变量决定是否启用Swagger-UI文档 */
        Profiles profiles = Profiles.of("dev", "test");
        enableSwaggerUI = environment.acceptsProfiles(profiles);
    }

    @Bean("clientAPI")
    public Docket clientAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("客户端")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(apiInfo());
    }

    @Bean("adminAPI")
    public Docket adminAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("管理后台")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.regex("/admin.*"))
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * 功能描述：SwaggerUI文档的基本信息
     *
     * @return
     * @Auther: 梁展鹏
     * @Date: 2018/8/2 10:21
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("骨架")
                .description("骨架 。。。")
                .termsOfServiceUrl("http://127.0.0.1")
                .contact(new Contact("", "", ""))
                .version("v0.0.1")
                .build();
    }

}
