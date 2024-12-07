package ru.mirea.khokhlov.data.repository;

import ru.mirea.khokhlov.data.Storage.MovieStorage;
import ru.mirea.khokhlov.domain.domain.Models.Movie;
import ru.mirea.khokhlov.domain.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {
    private MovieStorage movieStorage;

    public MovieRepositoryImpl(MovieStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    @Override
    public boolean saveMovie(Movie movie) {
        return movieStorage.saveMovie(movie);
    }

    @Override
    public Movie getMovie() {
        return movieStorage.get();
    }
}
