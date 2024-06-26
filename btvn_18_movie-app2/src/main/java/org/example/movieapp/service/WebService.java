package org.example.movieapp.service;

import lombok.RequiredArgsConstructor;
import org.example.movieapp.entity.Movie;
import org.example.movieapp.model.enums.MovieType;
import org.example.movieapp.respository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class WebService {
    private final MovieRepository movieRepository;

    public Page<Movie> findByType(MovieType type, Boolean status, Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by("publishedAt").descending());
        return movieRepository.findByTypeAndStatus(type, status, pageable);
    }

    public List<Movie> getHotMovie() {
        return movieRepository.findTop10ByStatusOrderByRatingDesc(true);
    }

    public Movie getMovieDetails(Integer id, String slug) {
        return movieRepository.findByIdAndSlugAndStatus(id, slug, true).orElse(null);
    }

    public List<Movie> getRelatedMovies(Movie movie) {
        return movieRepository
                .findTop6ByTypeAndStatusAndIdNotOrderByRatingDesc(movie.getType(), true, movie.getId());
    }
}
