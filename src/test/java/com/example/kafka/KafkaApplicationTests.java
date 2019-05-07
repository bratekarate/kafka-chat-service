package com.example.kafka;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class KafkaApplicationTests {

    @Test
    public void thisFails() {
        assertNotNull("NOT NULL");
    }

}
