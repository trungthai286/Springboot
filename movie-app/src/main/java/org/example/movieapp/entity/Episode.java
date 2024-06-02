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
@Table(name="episode")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    String name;

    int duration;
    int displayOder;
    String videoUrl;
    Boolean status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}