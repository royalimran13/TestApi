package net.javaguides.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class TestApiApplication {
	
	private static final Logger log = LoggerFactory.getLogger(TestApiApplication.class);


	public static void main(String[] args) {
		
		log.info("Test Api is in Running Mode");
		SpringApplication.run(TestApiApplication.class, args);
	}

}
