package ru.mirea.khokhlov.domain.domain.usecases;

import ru.mirea.khokhlov.domain.domain.Models.Movie;
import ru.mirea.khokhlov.domain.domain.repository.MovieRepository;

public class GetFavoriteFilmUseCase {
    private MovieRepository movieRepository;
    public GetFavoriteFilmUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Movie execute(){
        return movieRepository.getMovie();
    }
}
