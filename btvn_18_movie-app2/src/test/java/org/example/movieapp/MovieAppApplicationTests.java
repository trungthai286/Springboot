package org.example.movieapp;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.example.movieapp.entity.*;
import org.example.movieapp.model.enums.MovieType;
import org.example.movieapp.model.enums.Role;
import org.example.movieapp.respository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class MovieAppApplicationTests {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    void save_movies() {
        Faker faker = new Faker();
        Slugify slugify = Slugify.builder().build();

        for (int i = 0; i < 100; i++) {
            String name = faker.book().title();
            Boolean status = faker.bool().bool();
            Movie movie = Movie.builder()
                    .name(name)
                    .slug(slugify.slugify(name))
                    .description(faker.lorem().paragraph())
                    .poster("https://placehold.co/600x400?text=" + name.substring(0, 1).toUpperCase())
                    .releaseYear(faker.number().numberBetween(2021, 2024))
                    .rating(faker.number().randomDouble(1, 1, 10))
                    .trailerUrl("https://www.youtube.com/embed/YPY7J-flzE8?si=NIAaDGXL68JdDCux")
                    .type(MovieType.values()[faker.number().numberBetween(0, MovieType.values().length - 1)])
                    .status(status)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .publishedAt(status ? LocalDateTime.now() : null)
                    .build();
            movieRepository.save(movie);
        }
    }

    @Test
    void movie_methods_test() {
        //Select * from movies
        List<Movie> movies = movieRepository.findAll();
        System.out.println("movies size " + movies.size());

        //Select * from movies where id in (1,2,3)
        List<Movie> moviesById = movieRepository.findAllById(List.of(1, 2, 3));

        //select * from movies where id = 1
        Movie movie = movieRepository.findById(1).orElse(null);

        //Update
        movie.setName("a,b,c");
        movieRepository.save(movie);

        //delete
//        movieRepository.deleteById(2);
//        movieRepository.deleteAll();
//        movieRepository.delete(movie);
//        movieRepository.deleteAll(moviesById);

    }

    @Autowired
    private UserRepository userRepository;

    @Test
    void save_users() {
        Faker faker = new Faker();
        int adminCount = 0;
        int totalRecords = 30;

        for (int i = 0; i < totalRecords; i++) {
            Role role = Role.USER;
            if (adminCount < 2) {
                role = Role.ADMIN;
                adminCount++;
            }
            Users user = Users.builder()
                    .username(faker.name().fullName())
                    .password(faker.lorem().characters(3, 5))
                    .email(faker.internet().emailAddress())
                    .avatar(faker.internet().avatar())
                    .userRole(role)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            userRepository.save(user);
        }
    }

    @Autowired
    private CountryRepository countryRepository;

    @Test
    void save_country() {
        Faker faker = new Faker();
        Set<String> countryNames = new HashSet<>();
        int totalRecords = 20;
        int count = 0;

        while (count < totalRecords) {
            String countryName = faker.country().name();
            if (!countryNames.contains(countryName)) {
                countryNames.add(countryName);
                Country country = Country.builder()
                        .name(countryName)
                        .slug(faker.internet().slug())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build();
                countryRepository.save(country);
                count++;
            }
        }
    }

    @Autowired
    private GenreRespository genreRepository;

    @Test
    void save_genre() {
        Faker faker = new Faker();
        Set<String> genreNames = new HashSet<>();
        int totalRecords = 20;
        int count = 0;

        while (count < totalRecords) {
            String genreName = faker.book().genre();
            if (!genreNames.contains(genreName)) {
                genreNames.add(genreName);
                Genre genre = Genre.builder()
                        .name(genreName)
                        .slug(faker.internet().slug())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build();
                genreRepository.save(genre);
                count++;
            }
        }
    }

    @Autowired
    private DirectorRespository directorRepository;

    @Test
    void save_director() {
        Faker faker = new Faker();
        for (int i = 0; i < 30; i++) {
            Director director = Director.builder().
                    name(faker.name().fullName())
                    .slug(faker.internet().slug())
                    .avatar(faker.internet().avatar())
                    .bio(faker.lorem().paragraph())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            directorRepository.save(director);
        }
    }

    @Autowired
    private ActorRespository actorRepository;

    @Test
    void save_actor() {
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            Actor actor = Actor.builder()
                    .name(faker.name().fullName())
                    .slug(faker.internet().slug())
                    .avatar(faker.internet().avatar())
                    .bio(faker.lorem().paragraph())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            actorRepository.save(actor);
        }
    }
}
