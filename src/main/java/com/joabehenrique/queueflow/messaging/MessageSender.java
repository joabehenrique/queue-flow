package com.joabehenrique.queueflow.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joabehenrique.queueflow.dto.QueueDTO;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private Queue myQueue;

    public void sendMessageRabbitMQ(QueueDTO message) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(message);
        rabbitTemplate.convertAndSend("queue-first", json);
    }

    public void sendMessageKafka(String topic, QueueDTO message)  throws JsonProcessingException{
        String json = new ObjectMapper().writeValueAsString(message);
        kafkaTemplate.send(topic, json);
    }
}