package com.shubham.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket createDocket()
	{
		return new Docket(DocumentationType.SWAGGER_2) //swagger screen
				.select()//read rest controller
				.apis(RequestHandlerSelectors.basePackage("com.shubham.controller"))//api restcontroller from commom package name
				//.paths(PathSelectors.regex("/controller.*"))//having one common stating path
				.paths(PathSelectors.any())
				.build();//create screen
				//.apiInfo(apiInfo());//optional meta data info
	}
	
}
