package pt.ua.es.labProject.boot;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = { "pt.ua.es.labProject.model" })
@EnableJpaRepositories(basePackages = { "pt.ua.es.labProject.dao" })
@ComponentScan(basePackages = {"pt.ua.es.labProject.controller", "pt.ua.es.labProject.service", "pt.ua.es.labProject.webService"})
public class LoadPackageConfig {

}
