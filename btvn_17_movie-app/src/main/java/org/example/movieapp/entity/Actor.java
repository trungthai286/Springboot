package org.example.movieapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "actor")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    String name;

    String Slug;
    String avatar;
    String bio;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
