package com.example.chatAppDemo.chatAppDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	private final long MAX_AGE_SECS = 3600;
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("*")
	                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
	                .maxAge(MAX_AGE_SECS);
	    }
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {

	            registry.addResourceHandler("swagger-ui.html")
	                    .addResourceLocations("classpath:/META-INF/resources/");

	            registry.addResourceHandler("/webjars/**")
	                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
	            registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

	    }
	    
}
