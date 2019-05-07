package com.example.kafka.conf;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.kafka")
@Data
public class KafkaConfig {

    private String bootstrapServers;
    private String groupId;
}
