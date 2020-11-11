package com.example.adminportal.controller;

import com.example.adminportal.model.User;
import com.example.adminportal.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * Author: XLee
 * Date: 2020/11/11 19:43
 * Description:
 */
@Controller
public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public String toLogin(Model model, HttpSession session) {
        model.addAttribute("msg", "");
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
        //表单验证。后期可以改进
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        model.addAttribute(user);

        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            if (userService.login(username, password) == 1) {
                session.setAttribute("loginUser", username);
                return "redirect:/index";
            } else {
                model.addAttribute("msg", "用户名或密码错误！");
                return "login";
            }
        } else {
            model.addAttribute("msg", "用户名和密码不能为空！");
            return "login";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }




}
