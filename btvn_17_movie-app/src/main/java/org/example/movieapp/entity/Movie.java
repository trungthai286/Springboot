package org.example.movieapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.movieapp.model.enums.MovieType;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="movies")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String name;

    String Slug;

    @Column(columnDefinition = "TEXT")
    String description;

    String poster;
    Integer releaseYear;
    Double rating;
    String trainerUrl;

    @Enumerated(EnumType.STRING)
    MovieType type;

    Boolean status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    LocalDateTime publishedAt;

}
