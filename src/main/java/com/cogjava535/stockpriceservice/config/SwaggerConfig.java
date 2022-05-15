package com.cogjava535.stockpriceservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import static com.google.common.base.Predicates.or;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket toDoApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("company-details-service")
				.apiInfo(apiInfo())
				.select()
				.paths(PathSelectors.any())
				.build();
	}
	
	private Predicate<String> postPaths(){
		return or(regex("/company.*"),regex("*"));
	}
	
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("Company Details Service - Api for Stock Market Application")
				.description("Pulls company related details and managing company details endpoints")
				.version("1.0")
				.build();
	}
}
