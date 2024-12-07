package ru.mirea.khokhlov.data.repository;

import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Response;
import ru.mirea.khokhlov.data.database.dao.StarDao;
import ru.mirea.khokhlov.data.database.entity.StarEntity;
import ru.mirea.khokhlov.data.network.ApiClient;
import ru.mirea.khokhlov.data.network.StarApi;
import ru.mirea.khokhlov.domain.models.Star;
import ru.mirea.khokhlov.domain.repository.StarRepository;

public class StarRepositoryImpl implements StarRepository {
    private final StarDao starDao;
    private final StarApi starApiService;

    public StarRepositoryImpl(StarDao starDao) {
        this.starDao = starDao;
        starApiService = ApiClient.getRetrofitInstance().create(StarApi.class);
    }

    @Override
    public void getAllStars(Callback<List<Star>> callback) {
        // Сначала пытаемся загрузить данные с сервера
        new Thread(() -> {
            try {
                Response<List<Star>> response = starApiService.getAllStars().execute();
                if (response.isSuccessful() && response.body() != null) {
                    List<Star> stars = response.body();

                    // Сохраняем данные в локальную базу
                    saveStarsToDatabase(stars);

                    // Возвращаем данные
                    callback.onSuccess(stars);
                } else {
                    // Если сервер недоступен, загружаем из базы данных
                    loadStarsFromDatabase(callback);
                }
            } catch (Exception e) {
                // Если ошибка, загружаем из базы данных
                loadStarsFromDatabase(callback);
            }
        }).start();
    }
    @Override
    public boolean saveStar(Star star) {
        try {
            // Преобразуем модель Star в сущность StarEntity
            StarEntity entity = new StarEntity(star.getName(), star.getDescription(), star.getPhotoUrl());
            starDao.insertAll(Collections.singletonList(entity)); // Сохраняем в базу
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void saveStarsToDatabase(List<Star> stars) {
        List<StarEntity> entities = stars.stream()
                .map(star -> new StarEntity(star.getName(), star.getDescription(), star.getPhotoUrl()))
                .collect(Collectors.toList());
        starDao.insertAll(entities);
    }

    private void loadStarsFromDatabase(Callback<List<Star>> callback) {
        try {
            List<StarEntity> entities = starDao.getAllStars();
            List<Star> stars = entities.stream()
                    .map(entity -> new Star(entity.getName(), entity.getDescription(), entity.getPhotoUrl()))
                    .collect(Collectors.toList());
            callback.onSuccess(stars);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
