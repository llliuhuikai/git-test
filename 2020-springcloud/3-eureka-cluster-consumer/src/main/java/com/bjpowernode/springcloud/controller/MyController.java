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
    String result= restTemplate.getForEntity("http://3-eureka-cluster-provider/dosome",String.class).getBody();
    return result;
}
}
