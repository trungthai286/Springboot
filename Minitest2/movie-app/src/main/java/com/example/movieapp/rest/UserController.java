package com.example.movieapp.rest;

import com.example.movieapp.entity.User;
import com.example.movieapp.model.request.UpdateProfileUserRequest;
import com.example.movieapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/update-profile")
    public ResponseEntity<?> updateProfile(@RequestBody UpdateProfileUserRequest request) {
        User currentUser = userService.getCurrentUser(); // Lấy thông tin người dùng hiện tại từ service
        if (currentUser == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        // Update thông tin cá nhân
        currentUser.setName(request.getName());
        userService.save(currentUser);

        return ResponseEntity.ok("Profile updated successfully");
    }
}
