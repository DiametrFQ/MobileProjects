package ru.mirea.khokhlov.Lesson9.domains.usecases;

import ru.mirea.khokhlov.Lesson9.domains.models.Movie;
import ru.mirea.khokhlov.Lesson9.domains.repository.MovieRepository;

public class GetFavoriteFilmUseCase {

    private MovieRepository movieRepository;

    public GetFavoriteFilmUseCase(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    public Movie execute(){
        return movieRepository.getMovie();
    }

}