package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String uname,
                              @RequestParam String psw,
                              Model model) {
        // 这里你需要实现验证逻辑，验证用户名和密码
        // 假设这里直接做一个简单的验证
        if ("name".equals(uname) && "password".equals(psw)) {
            return "redirect:/loginSuccess"; // 登录成功重定向到登录成功页面
        } else {
            model.addAttribute("error", "用户名或密码不正确，请重试。");
            return "login"; // 登录失败返回登录页面并显示错误信息
        }
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess() {
        return "loginSuccess";
    }
}
