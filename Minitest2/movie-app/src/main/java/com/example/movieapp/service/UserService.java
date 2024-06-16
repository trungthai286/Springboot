package com.example.movieapp.service;

import com.example.movieapp.entity.User;
import com.example.movieapp.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final HttpSession session;

    // Lấy thông tin người dùng hiện tại từ session
    public User getCurrentUser() {
        return (User) session.getAttribute("currentUser");
    }

    // Lưu thông tin người dùng sau khi thay đổi
    public User save(User user) {
        return userRepository.save(user);
    }

    // Kiểm tra mật khẩu cũ
    public boolean checkPassword(User user, String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    // Cập nhật mật khẩu mới cho người dùng
    public void updatePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}
