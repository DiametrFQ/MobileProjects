package ru.mirea.khokhlov.data.Storage;

import ru.mirea.khokhlov.domain.domain.Models.Movie;

public interface MovieStorage {
    boolean saveMovie(Movie movie);
    Movie get();
}
