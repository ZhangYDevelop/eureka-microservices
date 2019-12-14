package com.zy.service.provider.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @AUTHOR zhangy
 * 2019-12-13  22:53
 */
//@EnableSwagger2
//@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("用户服务")
            .description("接口说明文档")
            .termsOfServiceUrl("")
            .contact(new Contact("zhangy","2389311433@qq.com","2389311433@qq.com"))
            .version("1.0")
            .build();
    }
}
