package ru.mirea.khokhlov.Lesson9.data.repository;

import ru.mirea.khokhlov.Lesson9.domains.models.Movie;
import ru.mirea.khokhlov.Lesson9.domains.repository.MovieRepository;

import android.content.Context;
import android.content.SharedPreferences;

public class MovieRepositoryImpl implements MovieRepository {

    private static final String PREFERENCES_NAME = "MoviePreferences";
    private static final String KEY_MOVIE_ID = "movie_id";
    private static final String KEY_MOVIE_TITLE = "movie_title";

    private SharedPreferences sharedPreferences;

    public MovieRepositoryImpl(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public boolean saveMovie(Movie movie) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_MOVIE_ID, movie.getId());
        editor.putString(KEY_MOVIE_TITLE, movie.getName());
        return editor.commit(); // Сохранение данных
    }

    @Override
    public Movie getMovie() {
        int movieId = sharedPreferences.getInt(KEY_MOVIE_ID, -1);
        String movieTitle = sharedPreferences.getString(KEY_MOVIE_TITLE, "No movie");

        if (movieId != -1 && !movieTitle.equals("No movie")) {
            return new Movie(movieId, movieTitle);
        } else {
            return new Movie(1, "Game of Thrones");
        }
    }
}
