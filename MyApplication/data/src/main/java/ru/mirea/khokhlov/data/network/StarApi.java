package ru.mirea.khokhlov.data.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.mirea.khokhlov.domain.models.Star;

public interface StarApi {
    @GET("/stars")
    Call<List<Star>> getAllStars();

    @GET("/stars/{id}")
    Call<Star> getStarById(@Path("id") int id);
}