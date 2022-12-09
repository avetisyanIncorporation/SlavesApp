package my.app.application;

import app.kafka.config.EnableSlaveKafkaLogic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "my.app")
@EnableJpaRepositories(basePackages = "my.app.domain.repository")
@EntityScan(basePackages = "my.app.domain.entity")
@EnableSlaveKafkaLogic
@EnableCaching
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

}
