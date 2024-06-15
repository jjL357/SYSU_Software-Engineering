package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String uname,
                              @RequestParam String psw,
                              Model model) {
        User user = userService.findUserByNameAndPassword(uname, psw);
        if (user != null) {
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
