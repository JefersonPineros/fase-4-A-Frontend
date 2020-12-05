package com.SkillexBackend.SkillexBackendDemo.controllers;

import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer  {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String resourcePath = Paths.get("images").toAbsolutePath().toUri().toString();
		registry.addResourceHandler("/images/**").addResourceLocations(resourcePath);
	}
}
