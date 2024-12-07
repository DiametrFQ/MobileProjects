package ru.mirea.khokhlov.domain.usecases;

import java.util.List;

import ru.mirea.khokhlov.domain.models.Star;
import ru.mirea.khokhlov.domain.repository.StarRepository;

public class GetFavoriteStarUseCase {
    private final StarRepository repository;

    public GetFavoriteStarUseCase(StarRepository repository) {
        this.repository = repository;
    }

    public void execute(StarRepository.Callback<List<Star>> callback) {
        repository.getAllStars(callback);
    }
}