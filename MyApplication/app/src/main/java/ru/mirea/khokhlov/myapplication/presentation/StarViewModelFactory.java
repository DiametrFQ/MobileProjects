package ru.mirea.khokhlov.myapplication.presentation;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.khokhlov.domain.usecases.GetFavoriteStarUseCase;

public class StarViewModelFactory implements ViewModelProvider.Factory {
    private final GetFavoriteStarUseCase getFavoriteStarUseCase;

    public StarViewModelFactory(GetFavoriteStarUseCase getFavoriteStarUseCase) {
        this.getFavoriteStarUseCase = getFavoriteStarUseCase;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(StarViewModel.class)) {
            return (T) new StarViewModel(getFavoriteStarUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}