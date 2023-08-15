package com.example.spring_boot_student_data.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfiguration {
	
	@Bean
	public Docket getDocket()
	{
		Contact contact = new Contact("Qspiders", "http://qspiders.com", "qspiderpune@gmail.com");
		List<VendorExtension> extensions = new ArrayList<>();	
		ApiInfo apiInfo = new ApiInfo("Student Management", "SM Version 1.0", "Version 1.0" , "1 year freee service", contact, 
				"License1234", "http://license1234.com", extensions);
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.spring_boot_student_data")).build()
						.apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
}
