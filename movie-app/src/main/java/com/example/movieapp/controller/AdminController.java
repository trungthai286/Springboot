package com.example.movieapp.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {
    @GetMapping("/admin/users")
    public String getUserList(Model model) {
        return "admin/user/index";
    }

    @GetMapping("/admin/users/create")
    public String createUser(Model model) {
        return "admin/user/create";
    }

    @GetMapping("/admin/users/{id}/detail")
    public String getUserDetail(@PathVariable Integer id, Model model) {
        return "admin/user/detail";
    }
}
