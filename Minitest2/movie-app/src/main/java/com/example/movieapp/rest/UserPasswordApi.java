package com.example.movieapp.rest;

import com.example.movieapp.entity.User;

import com.example.movieapp.model.request.UpdatePasswordRequest;
import com.example.movieapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserPasswordApi {
    private final UserService userService;

    @PutMapping("/update-password")
    public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordRequest request) {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        // Kiểm tra mật khẩu cũ có khớp không
        if (!userService.checkPassword(currentUser, request.getOldPassword())) {
            return ResponseEntity.badRequest().body("Old password is incorrect");
        }

        // Kiểm tra mật khẩu mới và mật khẩu xác nhận có trùng khớp không
        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("New password and confirm password do not match");
        }

        // Update mật khẩu mới cho người dùng
        userService.updatePassword(currentUser, request.getNewPassword());

        return ResponseEntity.ok("Password updated successfully");
    }
}
