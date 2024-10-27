package ru.mirea.khokhlov.Lesson9.domains.repository;

import ru.mirea.khokhlov.Lesson9.domains.models.Movie;

public interface MovieRepository {
    boolean saveMovie(Movie movie);

    Movie getMovie();
}
