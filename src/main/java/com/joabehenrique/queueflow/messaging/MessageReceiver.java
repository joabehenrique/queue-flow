package com.joabehenrique.queueflow.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @RabbitListener(queues = "queue-first")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}







