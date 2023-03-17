package com.joabehenrique.queueflow.controller;

import com.joabehenrique.queueflow.entity.Queue;
import com.joabehenrique.queueflow.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class QueueController {
    @Autowired
    private QueueService myService;

    @PostMapping("/myEndpoint")
    public void myEndpoint(@RequestBody Queue myModel) {
        myService.processMyModel(myModel);
    }
}





