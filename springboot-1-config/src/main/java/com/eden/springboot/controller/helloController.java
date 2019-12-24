package com.eden.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    //如果只是在业务逻辑里面获取某个值，我们就使用@Value的这种方式
    //但是如果说是写一个JavaBean就使用@ConfigurationProperties这种方式
    @Value("${person.last-name}")
    private String name;
    @RequestMapping("/sayHello")
    public String sayHello()
    {
        return "Hello"+name;
    }
}
