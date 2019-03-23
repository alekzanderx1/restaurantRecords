package com.worldrestaurants.project.configuration;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.PathExtensionContentNegotiationStrategy;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableAspectJAutoProxy
public class WebConfig extends WebMvcConfigurationSupport {

	@Autowired
	Environment environment;



	public WebConfig() {
		super();
	}
	
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {

		ContentNegotiatingViewResolver result = new ContentNegotiatingViewResolver();
		result.setOrder(1);

		ContentNegotiationManager mgr = new ContentNegotiationManager(
				new PathExtensionContentNegotiationStrategy((Map<String, MediaType>)java.util.Collections.singletonMap("json", MediaType.APPLICATION_JSON)),
				new HeaderContentNegotiationStrategy());

		result.setContentNegotiationManager(mgr);//MediaTypes(mediaTypes);

		MappingJackson2JsonView jacksonView = new MappingJackson2JsonView();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
		jacksonView.setObjectMapper(objectMapper);

		// jacksonView.setExtractValueFromSingleKeyModel(true);
		result.setDefaultViews(Collections.singletonList((View) jacksonView));
		//result.setIgnoreAcceptHeader(true);
		//result.setContentNegotiationManager(new ContentNegotiationManager(new FixedContentNegotiationStrategy(MediaType.APPLICATION_JSON)));
		return result;
	}


	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver result = new UrlBasedViewResolver();
		result.setOrder(2);
		result.setViewClass(TilesView.class);
		return result;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/**", "/resources/");
		registry.addResourceHandler("/views/**")
		.addResourceLocations("/views/**", "/views/");
	}

	@Bean
	public MultipartResolver multipartResolver() {
		MultipartResolver result = new CommonsMultipartResolver();
		return result;
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}

}
