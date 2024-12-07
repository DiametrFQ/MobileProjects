package ru.mirea.khokhlov.domain.repository;

import java.util.List;

import ru.mirea.khokhlov.domain.models.Star;


public interface StarRepository {
    void getAllStars(Callback<List<Star>> callback);

    boolean saveStar(Star star);

    interface Callback<T> {
        void onSuccess(T data);
        void onError(Exception e);
    }
}
