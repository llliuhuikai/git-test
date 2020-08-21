package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.controller.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {
@Autowired
    TestService testService;
@RequestMapping(value = "/test")
public  String  dosome(){
    String result= testService.test();

    return result;
}
}
