package com.bjpowernode.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {
    @RequestMapping(value = "/dosome")
    public  String dosome(){
        return "使用了zull服务提供者";
    }
}
