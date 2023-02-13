package com.natwest.userApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket getDocket() {
	return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.natwest.userApi"))
			.build().apiInfo(setDetails());
	}
	public ApiInfo setDetails() {
		 ApiInfoBuilder apiInfo = new ApiInfoBuilder();
		 return apiInfo.title("registration-Api").description("Regisration documentation of Paypal project")
		.version("1.0").build();
		
		
	}
}
