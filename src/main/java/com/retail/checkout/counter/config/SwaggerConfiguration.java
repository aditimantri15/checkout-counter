package com.retail.checkout.counter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration for the application which enables the API end points
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final String CONTROLLERS_BASE_PACKAGE = "com.retail.checkout.counter.controller";

    @Value("${api.version}")
    private String version;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLERS_BASE_PACKAGE))
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Checkout Counter in an Online Retail Store")
                .description("Checkout Counter in an Online Retail Store API in Spring Boot")
                .contact(new Contact("Aditi Mantri", "", "aditimantri15@gmail.com"))
                .version(version)
                .build();
    }
}
