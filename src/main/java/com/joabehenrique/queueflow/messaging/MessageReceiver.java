package com.joabehenrique.queueflow.messaging;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class MessageReceiver {

    @RabbitListener(queues = "queue-first")
    public void receiveMessage(String message) {
        System.out.println("\nReceived message: " + message + "\n");
    }
}







