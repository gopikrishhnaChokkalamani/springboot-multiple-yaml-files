package com.gi.springboot.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class AppConfig {

	@Bean
	public PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		
		//OPTION 1 - Load Individual Yaml Files
		yaml.setResources(new ClassPathResource("student.yml"), new ClassPathResource("address.yml"));
		// yaml.setResources(new ClassPathResource("address.yml"));
		
		//OPTION 2 - Load All Yaml Files
		//ClassLoader cl = this.getClass().getClassLoader();
		//ResourcePatternResolver rpResolver = new PathMatchingResourcePatternResolver(cl);
		//Resource configFiles = rpResolver.getResource("classpath*:/*.yml");
		//yaml.setResources(configFiles);
		
		//OPTION 3 - Using Spring Profiles
		//rename your yaml files to application-student.yml, application-address.yml
		//Comment this config file completely
		//Add        spring:
		//		        profiles:
		//		        	    include: 
		//		        	    	   - student
		//		        	    	   - address 
		//		  in application.yml
		
		propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
		return propertySourcesPlaceholderConfigurer;
	}
}
