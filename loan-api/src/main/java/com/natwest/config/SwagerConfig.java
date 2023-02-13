package com.natwest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwagerConfig {
	
	@Bean
	public Docket getDocket() {
	return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.natwest"))
			.build().apiInfo(setDetails());
	}
	public ApiInfo setDetails() {
		 ApiInfoBuilder apiInfo = new ApiInfoBuilder();
		 return apiInfo.title("loan-api").description("Loan application documentation of Insta-loan approval project")
		.version("1.0").build();
		
		
	}
}
