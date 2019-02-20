package pt.ua.es.labProject.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@EntityScan(basePackages = { "pt.ua.es.labProject.model" })
@EnableJpaRepositories(basePackages = { "pt.ua.es.labProject.dao" })
@ComponentScan(basePackages = {"pt.ua.es.labProject.controller"})
@SpringBootApplication
public class WebConfig {
	static Class[] listaConfiguracao = { LoadPackageConfig.class, WebConfig.class };
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
	}

	public static void main(String[] args) {
	SpringApplication.run(WebConfig.class, args);
	}
}
