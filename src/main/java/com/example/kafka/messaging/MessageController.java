package com.example.kafka.messaging;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

//    public ResponseEntity<String> sendMessage(Message message) {
//        messageService.sendMessage(message);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @MessageMapping("/chat.message")
    public void message(Message message) throws Exception {
//        Thread.sleep(1000); // simulated delay
        messageService.sendMessage(message);
    }

}
