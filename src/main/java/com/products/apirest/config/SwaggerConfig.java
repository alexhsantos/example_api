package com.products.apirest.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.products.apirest"))
				.paths(PathSelectors.regex("/api.*"))
				.build()
				.apiInfo(metaInfo());
	}
	
	@SuppressWarnings("rawtypes")
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"API Rest Product", 
				"API Rest of store products", 
				"1.0", 
				"Terms of Service",
				new Contact("Alex H Santos", "", "alex.hd.sant@gmail.com"), 
				"Apache License Version 2.0", 
				"https://www.apache.org/license.html",
				new ArrayList<VendorExtension>()
		);
		
		return apiInfo;
	}
	
}
