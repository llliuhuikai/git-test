package com.bjpowernode.springcloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @RequestMapping(value = "/doother")
    public String doOther(){
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> result= restTemplate.getForEntity("http://localhost:8081/dosome",String.class);
        System.out.println(result.getStatusCode());
        System.out.println(result.getHeaders());
         String body=result.getBody();
        return "我的消费者" +body;
    }
}
