package com.kdmeo.rest.config;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerAdaptor {
	
	/**
	 * Builder for swagger-Spring MVC
	 * @return
	 */
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.kdmeo.rest.controller"))
	      .paths(PathSelectors.ant("/api/**"))
	      .build()
	      .apiInfo(apiInfo());
	}
	 
	private ApiInfo apiInfo() {
	   return ApiInfo.DEFAULT;
	}
}
