package com.example.demo.controller;

import com.example.demo.security.IAuthenticationFacade;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class Webcontroller {

    @Autowired
    private IAuthenticationFacade iAuthenticationFacade;

    @GetMapping("/")
    public String getHome() {
        return "Home Page";
    }

    @GetMapping("/user")
    public String getUser() {
        return "User Page";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Admin Page";
    }

    @GetMapping("info-1")
    public ResponseEntity<?> getInfo1() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(authentication);
    }


    @GetMapping("info-2")
    public ResponseEntity<?> getInfo2(Principal principal) {
        return ResponseEntity.ok(principal);
    }

    @GetMapping("info-3")
    public ResponseEntity<?> getInfo3(Authentication authentication) {
        return ResponseEntity.ok(authentication);
    }

    @GetMapping("info-4")
    public ResponseEntity<?> getInfo4(HttpServletRequest request) {
        return ResponseEntity.ok(request);
    }

    @GetMapping("info-5")
    public ResponseEntity<?> getInfo5() {
        return ResponseEntity.ok(iAuthenticationFacade.getAuthentication());
    }

    //Bai tap

    @GetMapping("/dashboard")
    public String viewDashboard() {
        return "Dashboard content";
    }

    @GetMapping("/users")
    public String listUsers() {
        return "List of users";
    }

    @GetMapping("/categories")
    public String listCategories() {
        return "List of categories";
    }

    @GetMapping("/products")
    public String listProducts() {
        return "List of products";
    }

    @GetMapping("/brands")
    public String listBrands() {
        return "List of brands";
    }

    @GetMapping("/orders")
    public String listOrders() {
        return "List of orders";
    }

    @GetMapping("/posts")
    public String listPosts() {
        return "List of posts";
    }

    @GetMapping("/profile")
    public String viewProfile() {
        return "View profile";
    }

}
