package org.example.movieapp.respository;

import org.example.movieapp.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRespository extends JpaRepository<History, Integer> {
}
