package com.bjpowernode.springcloud.controller;

import com.netflix.loadbalancer.IRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {
@Autowired
    private RestTemplate restTemplate;
@Autowired
private IRule iRule;
@RequestMapping(value = "/test")
public  String  dosome(){
    String result= restTemplate.getForEntity("http://4-eureka-ribbon-provider-8002/dosome",String.class).getBody();
    return result+"负载均衡";
}
}
