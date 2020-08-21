package com.bjpowernode.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {
@Autowired
    private RestTemplate restTemplate;
@RequestMapping(value = "/test")
public  String  dosome(){
    String result= restTemplate.getForObject("http://7-eureka-zuul-provider/dosome",String.class);
    return "没有使用zull消费者"+result;
}
    @RequestMapping(value = "/test2")
    public  String  dosome2(){
        String result= restTemplate.getForObject("http://7-eureka-zuul-gateway/api-zull/dosome",String.class);
        return "使用了zull消费者"+result;
    }
}
