package com.example.kafka.messaging;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageResponse extends Message{
    private final LocalDateTime time;

    public MessageResponse(String text, String from, LocalDateTime time) {
        super(text, from);
        this.time = time;
    }
}
