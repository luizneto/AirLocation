package pt.ua.es.labProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirplaneController {
	
	private static final Logger log = LoggerFactory.getLogger(AirplaneController.class);
	public static void main(String[] args) {
			SpringApplication.run(AirplaneController.class, args);
		}
	
		@Bean
		public RestTemplate restTemplate(RestTemplateBuilder builder) {
			return builder.build();
		}
	
		@Bean
		public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
			return args -> {
				Quote quote = restTemplate.getForObject("https://opensky-network.org/api/states/all?lamin=45.8389&lomin=5.9962&lamax=47.8229&lomax=10.5226",Quote.class);
				log.info(quote.toString());
			};
		}

	}
