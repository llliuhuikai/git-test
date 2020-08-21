package com.bjpowernode.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {
    @RequestMapping(value = "/dosome")
    public  String dosome(){

        System.out.println(10/0);return "使用了feign的提供者";
    }
}
