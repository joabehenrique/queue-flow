package com.joabehenrique.queueflow.service;


import com.joabehenrique.queueflow.dto.QueueDTO;
import com.joabehenrique.queueflow.entity.Queue;
import com.joabehenrique.queueflow.messaging.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueService {
    @Autowired
    private MessageSender messageSender;

    public Queue processMyModel(QueueDTO queue) {
        Queue queueNew = new Queue("ei", 1);
        String a = "aaa";
        messageSender.sendMessage(a);
        return queueNew;
    }
}
