package org.example.movieapp.respository;

import org.example.movieapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository <Movie, Integer>{
}
