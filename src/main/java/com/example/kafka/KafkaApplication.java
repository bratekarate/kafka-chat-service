package com.example.kafka;

import com.example.kafka.conf.WebSecurityConfig;
import com.example.kafka.messaging.Message;
import com.example.kafka.messaging.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

@SpringBootApplication
@RequiredArgsConstructor
@ComponentScan(basePackageClasses = {KafkaApplication.class, WebSecurityConfig.class})
public class KafkaApplication {

    final MessageService messageService;
    final KafkaAdmin kafkaAdmin;

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void run() {
//        messageService.sendMessage("HELLO KAFKAAAA!");
//    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            messageService.sendMessage(new Message("HELLO KAFKAAAA!", "GOTT"));
        };
    }

}
