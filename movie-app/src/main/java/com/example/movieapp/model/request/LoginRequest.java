package com.example.movieapp.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequest {
    @NotEmpty(message = "Email khong duoc de trong")
    @Email(message = "Email khong dung dinh dang")
    String email;

    @NotEmpty(message = "Mat khau khong duoc de trong")
    @Length(min = 3, message = "mk khong dung dinh dang")
    String password;
}
