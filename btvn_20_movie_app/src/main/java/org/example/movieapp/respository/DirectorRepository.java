package org.example.movieapp.respository;

import org.example.movieapp.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director,Integer> {
}
