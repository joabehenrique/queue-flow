package com.joabehenrique.queueflow.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joabehenrique.queueflow.dto.QueueDTO;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class MessageReceiver {

    @RabbitListener(queues = "queue-first")
    public void receiveMessageRabbitMQ(String message) throws JsonProcessingException {
        QueueDTO queueDTO = new ObjectMapper().readValue(message, QueueDTO.class);
        System.out.println("\nReceived message RabbitMQ: " + queueDTO + "\n");
    }

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void receiveMessageKafka(String message) {
        System.out.println("Received message Kafka: " + message);
    }
}







