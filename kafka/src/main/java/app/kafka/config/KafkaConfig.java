package app.kafka.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@ConditionalOnProperty(name="slave.kafka.enable")
@Configuration
@ComponentScan(basePackages = "app.kafka")
@EnableKafka
public class KafkaConfig {
}
