package ru.mirea.khokhlov.Lesson9;

import androidx.lifecycle.ViewModel;

import ru.mirea.khokhlov.domain.domain.Models.Movie;
import ru.mirea.khokhlov.domain.domain.repository.MovieRepository;
import ru.mirea.khokhlov.domain.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.khokhlov.domain.domain.usecases.SaveMovieToFavoriteUseCase;

public class MainViewModel extends ViewModel {
    private MovieRepository movieRepository;

    public MainViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public boolean saveMovie(Movie movie) {
        return new SaveMovieToFavoriteUseCase(movieRepository).execute(movie);
    }

    public Movie getMovie() {
        return new GetFavoriteFilmUseCase(movieRepository).execute();
    }
}
