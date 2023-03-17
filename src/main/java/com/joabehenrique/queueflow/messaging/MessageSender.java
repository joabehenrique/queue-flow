package com.joabehenrique.queueflow.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue myQueue;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(myQueue.getName(), message);
    }
}