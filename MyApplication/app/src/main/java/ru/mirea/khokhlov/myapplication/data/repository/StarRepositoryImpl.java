package ru.mirea.khokhlov.myapplication.data.repository;

import android.content.Context;
import android.content.SharedPreferences;

import ru.mirea.khokhlov.myapplication.domains.models.Star;
import ru.mirea.khokhlov.myapplication.domains.repository.MovieRepository;

public class StarRepositoryImpl implements MovieRepository {

    private static final String PREFERENCES_NAME = "MoviePreferences";
    private static final String KEY_MOVIE_ID = "movie_id";
    private static final String KEY_MOVIE_TITLE = "movie_title";

    private SharedPreferences sharedPreferences;

    public StarRepositoryImpl(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public boolean saveMovie(Star movie) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_MOVIE_ID, movie.getId());
        editor.putString(KEY_MOVIE_TITLE, movie.getName());
        return editor.commit(); // Сохранение данных
    }

    @Override
    public Star getMovie() {
        int movieId = sharedPreferences.getInt(KEY_MOVIE_ID, -1);
        String movieTitle = sharedPreferences.getString(KEY_MOVIE_TITLE, "No movie");

        if (movieId != -1 && !movieTitle.equals("No movie")) {
            return new Star(movieId, movieTitle);
        } else {
            return new Star(1, "Game of Thrones");
        }
    }
}
