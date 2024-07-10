package com.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

	/**
	 * Method to set paths to be included through swagger
	 *
	 * @return Docket
	 */
	@Bean
	public Docket configApi() {
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/").select()
//				.paths(regex("/api.*")).build();
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}


	/**
	 * Method to set swagger info
	 *
	 * @return ApiInfoBuilder
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Sample API").description("Sample API Description").version("1.0").build();
	}
}