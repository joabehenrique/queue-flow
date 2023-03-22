package com.joabehenrique.queueflow.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.joabehenrique.queueflow.dto.QueueDTO;
import com.joabehenrique.queueflow.entity.Queue;
import com.joabehenrique.queueflow.messaging.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueService {
    @Autowired
    private MessageSender messageSender;

    public Queue processMyModel(QueueDTO queue) throws JsonProcessingException {
        messageSender.sendMessageRabbitMQ(queue);
        messageSender.sendMessageKafka("my-topic", queue);
        Queue queueNew = new Queue(queue.getField1(), queue.getField2());
        return queueNew;
    }
}
