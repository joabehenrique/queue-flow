package com.joabehenrique.queueflow.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joabehenrique.queueflow.dto.QueueDTO;
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

    public void sendMessage(QueueDTO message) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(message);
        rabbitTemplate.convertAndSend("queue-first", json);
        rabbitTemplate.convertAndSend(myQueue.getName(), message);
    }
}