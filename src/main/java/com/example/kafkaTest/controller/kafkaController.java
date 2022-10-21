package com.example.kafkaTest.controller;

import com.example.kafkaTest.model.LinkmanResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class kafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping(value = "/send")
    public String publishMessage(@RequestBody LinkmanResult linkmanResult){

        try{
            String jsonValue = new ObjectMapper().writeValueAsString(linkmanResult);
            String key = linkmanResult.getUrl() + " " + linkmanResult.getEventId();
            kafkaTemplate.send("linkman-output-result", key,  jsonValue);
            return "Message publish";
        }
        catch(Exception e){
            return "Error - " + e.getMessage();
        }
    }

}
