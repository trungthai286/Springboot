package org.example.movieapp.controller;


import lombok.RequiredArgsConstructor;
import org.example.movieapp.entity.Movie;
import org.example.movieapp.model.enums.MovieType;
import org.example.movieapp.service.WebService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class webController {
    private final WebService webService;

    @GetMapping
    public String getHomePage(Model model) {
        List<Movie>dsPhimHot=webService.getHotMovie();
        List<Movie>dsPhimBo=webService.findByType(MovieType.PHIM_BO, true, 1, 6).getContent();
        List<Movie>dsPhimLe=webService.findByType(MovieType.PHIM_LE, true, 1, 6).getContent();
        List<Movie>dsPhimChieuRap=webService.findByType(MovieType.PHIM_CHIEU_RAP, true, 1, 6).getContent();
        model.addAttribute("dsPhimHot",dsPhimHot);
        model.addAttribute("dsPhimBo",dsPhimBo);
        model.addAttribute("dsPhimLe",dsPhimLe);
        model.addAttribute("dsPhimChieuRap",dsPhimChieuRap);
        return "web/index";
    }

    @GetMapping("/phim-bo")
    public String getPhimBoPage(Model model,
                                @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "12") Integer limit) {
        Page<Movie> pageData = webService.findByType(MovieType.PHIM_BO, true, page, limit);
        model.addAttribute("pageData", pageData);
        model.addAttribute("currentPage", page);
        return "web/phim-bo";
    }

    @GetMapping("/phim-le")
    public String getPhimLePage(Model model,
                                @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "12") Integer limit) {
        Page<Movie> pageData = webService.findByType(MovieType.PHIM_LE, true, page, limit);
        model.addAttribute("pageData", pageData);
        model.addAttribute("currentPage", page);
        return "web/phim-le";
    }

    @GetMapping("/phim-chieu-rap")
    public String getPhimChieuRapPage(Model model,
                                @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "12") Integer limit) {
        Page<Movie> pageData = webService.findByType(MovieType.PHIM_CHIEU_RAP, true, page, limit);
        model.addAttribute("pageData", pageData);
        model.addAttribute("currentPage", page);
        return "web/phim-chieu-rap";
    }

    @GetMapping("/phim/{id}/{slug}")
    public String getMovieDetailsPage(@PathVariable Integer id,
                                      @PathVariable String slug,
                                      Model model) {
        Movie movie = webService.getMovieDetails(id, slug);
        List<Movie> relatedMovies = webService.getRelatedMovies(movie);

        model.addAttribute("movie", movie);
        model.addAttribute("relatedMovies", relatedMovies);
        return "web/chi-tiet-phim";
    }
}
