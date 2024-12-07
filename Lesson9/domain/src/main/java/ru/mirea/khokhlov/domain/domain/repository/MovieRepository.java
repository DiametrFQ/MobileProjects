package ru.mirea.khokhlov.domain.domain.repository;

import ru.mirea.khokhlov.domain.domain.Models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}
