package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Cau hinh duong dan
        String[] publicRoutes = new String[]{"/css/**", "/js/**", "/images/**", "/**/favion.ico"};
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/").permitAll();
            auth.requestMatchers("/user").hasRole("USER");
            auth.requestMatchers("/admin").hasRole("ADMIN");
            auth.requestMatchers("/all").hasAnyRole("USER", "ADMIN");
            auth.requestMatchers(HttpMethod.POST, "/post").hasRole("AUTHOR");
            auth.requestMatchers(HttpMethod.GET, "/get").hasAuthority("ROLE_USER");
            auth.requestMatchers("/alllll").hasAuthority("ROLE_USER, ROLE_ADMIN");
            auth.anyRequest().authenticated();
        });


        //Cau hinh form login
        http.formLogin(form -> {
            form.defaultSuccessUrl("/", true);
            form.permitAll();

        });

        // Cau hinh form Logout
        http.logout(logout -> {
            logout.logoutSuccessUrl("/");
            logout.invalidateHttpSession(true);
            logout.deleteCookies("JSESSIONID");
            logout.clearAuthentication(true);
            logout.permitAll();
        });

        return http.build();
    }


    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/api/dashboard").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers("/api/users").hasRole("ADMIN");
            auth.requestMatchers("/api/categories").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers("/api/products").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers("/api/brands").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers("/api/orders").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers("/api/posts").hasAnyRole("ADMIN", "SALE", "AUTHOR");
            auth.requestMatchers("/api/profile").hasRole("USER");
            auth.anyRequest().authenticated();
        });

        //Cau hinh form login
        http.formLogin(form -> {
            form.defaultSuccessUrl("/", true);
            form.permitAll();

        });

        // Cau hinh form Logout
        http.logout(logout -> {
            logout.logoutSuccessUrl("/");
            logout.invalidateHttpSession(true);
            logout.deleteCookies("JSESSIONID");
            logout.clearAuthentication(true);
            logout.permitAll();
        });

        return http.build();
    }
}
