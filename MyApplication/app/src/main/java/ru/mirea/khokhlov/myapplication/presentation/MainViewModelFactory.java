package ru.mirea.khokhlov.myapplication.presentation;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.khokhlov.domain.repository.StarRepository;
import ru.mirea.khokhlov.domain.usecases.GetFavoriteStarUseCase;
import ru.mirea.khokhlov.domain.usecases.SaveStarToFavoriteUseCase;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private final StarRepository starRepository;

    public MainViewModelFactory(StarRepository starRepository) {
        this.starRepository = starRepository;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(new GetFavoriteStarUseCase(starRepository));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}