package com.example.hospital.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

/**
 * Swagger 文档配置
 */
@Configuration
public class Swagger3Config {
    /**
     * 医院挂号平台-后端
     * @return
     */
    @Bean
    public Docket adminRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("hospital-admin")
                .apiInfo(adminApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.hospital.controller"))
                .paths(PathSelectors.regex("/admin/.*"))
                .build();
    }

    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("医院挂号平台API-后端")
                .description("本文档描述了医院挂号平台-后端微服务接口定义")
                .contact(new Contact("huangjiahao", null, null))
                .version("1.0")
                .build();
    }

    /**
     * 医院挂号平台-前端
     * @return
     */
    @Bean
    public Docket webRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("hospital-web")
                .apiInfo(webApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.hospital.controller.api"))
                .paths(PathSelectors.regex("/api/.*"))
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("医院挂号平台API-前端")
                .description("本文档描述了医院挂号平台-前端微服务接口定义")
                .contact(new Contact("huangjiahao", null, null))
                .version("1.0")
                .build();
    }
}
