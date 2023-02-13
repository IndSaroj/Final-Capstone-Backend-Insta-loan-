package com.natwest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.natwest.filter.APIFilter;

@Configuration
public class ApiGatewayConfig {
	
	@Autowired
	private APIFilter apiFilter;
	
	//api-gateway is used to route all microservices via single port i.e 8080
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				           .route(r -> r.path("/login")
			        		      .uri("http://localhost:8084"))
				        .route(r -> r.path("/api/user/**")
			        		      .uri("http://localhost:8085"))	
				        .route(r -> r.path("/api/applicant/**")
				        		.filters(f -> f.filters(apiFilter))
			        		     .uri("http://localhost:8089"))
				                  .build();
	}
}