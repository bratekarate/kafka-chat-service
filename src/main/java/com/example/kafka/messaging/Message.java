package com.example.kafka.messaging;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Message {
    private final String text;
    private final String from;

    @JsonCreator
    public Message(@JsonProperty("text") String text, @JsonProperty("from") String from) {
        this.text = text;
        this.from = from;
    }
}
