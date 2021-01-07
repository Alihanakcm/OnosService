package com.example.demo.controller.swagger;


import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/api/**"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Program in java APIs")
                .description("Program in java APIs reference for developers")
                .termsOfServiceUrl("https://www.programinjava.com")
                .contact("admin@programinjava.com").license("Free License")
                .licenseUrl("admin@programinjava.com").version("1.0").build();
    }
}
