package ru.mirea.khokhlov.myapplication.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.mirea.khokhlov.domain.models.Star;
import ru.mirea.khokhlov.domain.repository.StarRepository;
import ru.mirea.khokhlov.domain.usecases.GetFavoriteStarUseCase;

public class StarViewModel extends ViewModel {

    private final GetFavoriteStarUseCase getFavoriteStarUseCase;
    private final MutableLiveData<List<Star>> starsLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public StarViewModel(GetFavoriteStarUseCase getFavoriteStarUseCase) {
        this.getFavoriteStarUseCase = getFavoriteStarUseCase;
    }

    public LiveData<List<Star>> getStars() {
        return starsLiveData;
    }

    public LiveData<String> getErrors() {
        return errorLiveData;
    }

    public void loadStars() {
        getFavoriteStarUseCase.execute(new StarRepository.Callback<List<Star>>() {
            @Override
            public void onSuccess(List<Star> stars) {
                starsLiveData.postValue(stars); // Успешная загрузка данных
            }

            @Override
            public void onError(Exception e) {
                errorLiveData.postValue(e.getMessage()); // Обработка ошибки
            }
        });
    }
}