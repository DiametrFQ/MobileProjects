package ru.mirea.khokhlov.myapplication.domains.usecases;

import ru.mirea.khokhlov.myapplication.domains.models.Star;
import ru.mirea.khokhlov.myapplication.domains.repository.MovieRepository;

public class GetFavoriteStarUseCase {

    private MovieRepository movieRepository;

    public GetFavoriteStarUseCase(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    public Star execute(){
        return movieRepository.getMovie();
    }

}