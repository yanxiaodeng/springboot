package com.eden.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	//测试的controller
    @GetMapping("/hello")
    public String hello(Model model)
    {
        model.addAttribute("msg","你好呀！！！");
        return "success";
    }
}
