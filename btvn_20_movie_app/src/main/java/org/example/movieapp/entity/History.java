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
@Table(name="history")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    Double duration;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name="movie_id")
    Movie movie;

    @ManyToOne
    @JoinColumn(name="user_id")
    Users users;

    @ManyToOne
    @JoinColumn(name="episode_id")
    Episode episode;
}
