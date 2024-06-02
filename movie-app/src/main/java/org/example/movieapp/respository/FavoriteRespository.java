package org.example.movieapp.respository;

import org.example.movieapp.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRespository extends JpaRepository<Favorite, Integer> {
}
