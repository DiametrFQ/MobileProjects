package ru.mirea.khokhlov.domain.domain.usecases;

import ru.mirea.khokhlov.domain.domain.Models.Movie;
import ru.mirea.khokhlov.domain.domain.repository.MovieRepository;

public class SaveMovieToFavoriteUseCase {
    private MovieRepository movieRepository;
    public SaveMovieToFavoriteUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public boolean execute(Movie movie)
    {
        return movieRepository.saveMovie(movie);
    }
}
