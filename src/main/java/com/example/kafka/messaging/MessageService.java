package com.example.kafka.messaging;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Service
@RequiredArgsConstructor
public class MessageService {
    private static final String GROUP_TEST = "test";
    private final KafkaTemplate<String, Message> kafkaTemplate;
    private final SimpMessagingTemplate simpMessagingTemplate;
//    private final NewTopic topic1;

    public void sendMessage(Message message) {

        ListenableFuture<SendResult<String, Message>> future =
                kafkaTemplate.send(
                    MessageBuilder
                            .withPayload(message)
                            .setHeader(KafkaHeaders.TOPIC, "THEMA")
                            .build()
                );

        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, Message> result) {
                System.out.println("Sent message=[" + message.toString() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });
    }

    @KafkaListener(topics = "THEMA", groupId = GROUP_TEST)
    public void listen(@Payload Message message,
                       @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp) {
        System.out.println("Received Messasge in group " + GROUP_TEST + " " + message);
        simpMessagingTemplate.convertAndSend("/topic/chat.message",
                new MessageResponse(
                        message.getText(),
                        message.getFrom(),
                        LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), TimeZone.getDefault().toZoneId())
                ));
    }
}

