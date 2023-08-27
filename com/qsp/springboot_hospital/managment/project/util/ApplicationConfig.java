package com.qsp.springboot_hospital.managment.project.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {
	@Bean
	public Docket getDocket() {
		springfox.documentation.service.Contact contact = new springfox.documentation.service.Contact("Qspiders",
				"http://qspiders.com", "qspiderspune@gmail.com");
		List<VendorExtension> extensions = new ArrayList<>();
		ApiInfo apiInfo = new ApiInfo("Hospital Management App", "HM version 1.0", "Version 1.0", "1 year free service",
				contact, "QWERTY1234", "http://qwerty1234.com", extensions);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.qsp.springboot_hospital.managment.project")).build()
				.apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
}
