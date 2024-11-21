package ru.mirea.khokhlov.myapplication.domains.usecases;

import ru.mirea.khokhlov.myapplication.domains.models.Star;
import ru.mirea.khokhlov.myapplication.domains.repository.MovieRepository;

public class SaveStarToFavoriteUseCase {

    private MovieRepository movieRepository;

    public SaveStarToFavoriteUseCase(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    public boolean execute(Star movie){
        return movieRepository.saveMovie(movie);
    }
}