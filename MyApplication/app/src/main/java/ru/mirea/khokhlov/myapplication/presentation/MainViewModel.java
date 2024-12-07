package ru.mirea.khokhlov.myapplication.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.mirea.khokhlov.domain.models.Star;
import ru.mirea.khokhlov.domain.repository.StarRepository;
import ru.mirea.khokhlov.domain.usecases.GetFavoriteStarUseCase;

public class MainViewModel extends ViewModel {

    private final GetFavoriteStarUseCase getFavoriteStarUseCase;
    private final MutableLiveData<List<Star>> starsLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public MainViewModel(GetFavoriteStarUseCase getFavoriteStarUseCase) {
        this.getFavoriteStarUseCase = getFavoriteStarUseCase;
    }

    public LiveData<List<Star>> getAllStars() {
        // Передаём Callback при вызове execute
        getFavoriteStarUseCase.execute(new StarRepository.Callback<List<Star>>() {
            @Override
            public void onSuccess(List<Star> stars) {
                starsLiveData.postValue(stars); // Успешная загрузка
            }

            @Override
            public void onError(Exception e) {
                errorLiveData.postValue(e.getMessage()); // Ошибка загрузки
            }
        });
        return starsLiveData;
    }

    public LiveData<String> getErrorLiveData() {
        return errorLiveData;
    }

    public void loadStars() {
        getFavoriteStarUseCase.execute(new StarRepository.Callback<List<Star>>() {
            @Override
            public void onSuccess(List<Star> stars) {
                starsLiveData.postValue(stars);
            }

            @Override
            public void onError(Exception e) {
                errorLiveData.postValue("Failed to load stars: " + e.getMessage());
            }
        });
    }
}