package ru.mirea.khokhlov.myapplication.domains.repository;

import ru.mirea.khokhlov.myapplication.domains.models.Star;

public interface MovieRepository {
    boolean saveMovie(Star movie);

    Star getMovie();
}
