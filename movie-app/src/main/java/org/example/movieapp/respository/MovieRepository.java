package org.example.movieapp.respository;

import org.example.movieapp.entity.Movie;
import org.example.movieapp.model.enums.MovieType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository <Movie, Integer>{

    //Normal Query
//    List<Movie> findByName(String name);
//    List<Movie> findByNameIgnoreCase(String name);
//    List<Movie> findByNameContaining(String keyword);
//
//    List<Movie> findByTypeAndStatus(MovieType type, Boolean status);
//    List<Movie> findByReleaseYearBetween(Integer startYear, Integer endYear);
//    List<Movie> findByReleaseYearIn(List<Integer> years);
//    List<Movie> findByPublishedAtAfter(LocalDateTime date);
//
//    List<Movie> findByRatingGreaterThanEqual(Double rating);
//    List<Movie> findByTrailerUrlNull();
//
//    //Advanced Query (Phan trang, sap xep)
//   Page<Movie> findByTypeAndStatus(MovieType type, Boolean status, Pageable pageable);
//
//    List<Movie> findByNameContainingOrderByNameDesc(String keyword);
//
//    List<Movie> findByNameContainingOrderByNameDescRatingAsc(String keyword);
//
//    List<Movie> findByNameContaining(String keyword, Sort sort);
//
//    List<Movie> findFirstByNameContaining(String keyword, Sort sort);
//
//    List<Movie> findTop3ByNameContaining(String keyword);
    Page<Movie>findByTypeAndStatus(MovieType type, Boolean status, Pageable pageable);
}
