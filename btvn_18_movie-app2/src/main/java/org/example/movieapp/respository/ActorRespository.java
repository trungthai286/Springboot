package org.example.movieapp.respository;

import org.example.movieapp.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRespository extends JpaRepository<Actor,Integer> {
}
