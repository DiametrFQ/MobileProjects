package ru.mirea.khokhlov.domain.usecases;

import ru.mirea.khokhlov.domain.models.Star;
import ru.mirea.khokhlov.domain.repository.StarRepository;

public class SaveStarToFavoriteUseCase {

    private StarRepository starRepository;

    public SaveStarToFavoriteUseCase(StarRepository starRepository) {
        this.starRepository = starRepository;
    }

    public boolean execute(Star star) {
        return starRepository.saveStar(star);
    }
}