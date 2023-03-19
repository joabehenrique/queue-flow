package com.joabehenrique.queueflow.controller;

import com.joabehenrique.queueflow.dto.QueueDTO;
import com.joabehenrique.queueflow.entity.Queue;
import com.joabehenrique.queueflow.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/queue")
public class QueueController {
    @Autowired
    private QueueService myService;

    @PostMapping
    public ResponseEntity<Queue> myEndpoint(@RequestBody QueueDTO queueBody) {
        Queue queue = myService.processMyModel(queueBody);
        return new ResponseEntity<>(queue, HttpStatus.CREATED);
    }
}





