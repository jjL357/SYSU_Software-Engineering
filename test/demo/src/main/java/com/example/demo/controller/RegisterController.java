package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String register() {
        return "register"; // 返回注册页面的Thymeleaf模板名称
    }
}
