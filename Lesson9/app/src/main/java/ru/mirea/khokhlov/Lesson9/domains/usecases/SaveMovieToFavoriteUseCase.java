package ru.mirea.khokhlov.Lesson9.domains.usecases;

import ru.mirea.khokhlov.Lesson9.domains.models.Movie;
import ru.mirea.khokhlov.Lesson9.domains.repository.MovieRepository;

public class SaveMovieToFavoriteUseCase {

    private MovieRepository movieRepository;

    public SaveMovieToFavoriteUseCase(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    public boolean execute(Movie movie){
        return movieRepository.saveMovie(movie);
    }
}