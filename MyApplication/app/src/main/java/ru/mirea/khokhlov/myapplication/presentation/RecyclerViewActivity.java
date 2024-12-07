package ru.mirea.khokhlov.myapplication.presentation;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.khokhlov.data.database.StarDatabase;
import ru.mirea.khokhlov.data.database.dao.StarDao;
import ru.mirea.khokhlov.data.repository.StarRepositoryImpl;
import ru.mirea.khokhlov.domain.models.Star;
import ru.mirea.khokhlov.domain.repository.StarRepository;
import ru.mirea.khokhlov.domain.usecases.GetFavoriteStarUseCase;
import ru.mirea.khokhlov.myapplication.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StarAdapter adapter;

    private GetFavoriteStarUseCase getFavoriteStarUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        // Инициализация RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Устанавливаем пустой адаптер
        adapter = new StarAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        // Инициализация базы данных и репозитория
        StarDao starDao = StarDatabase.getInstance(this).starDao();
        StarRepositoryImpl repository = new StarRepositoryImpl(starDao);

        // Инициализация UseCase
        getFavoriteStarUseCase = new GetFavoriteStarUseCase(repository);

        // Загружаем данные
        loadStars();
    }

    private void loadStars() {
        // Выполняем асинхронную загрузку
        getFavoriteStarUseCase.execute(new StarRepository.Callback<List<Star>>() {
            @Override
            public void onSuccess(List<Star> stars) {
                runOnUiThread(() -> {
                    if (stars != null && !stars.isEmpty()) {
                        adapter.updateStars(stars);
                        Toast.makeText(RecyclerViewActivity.this, "Stars loaded successfully!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RecyclerViewActivity.this, "No stars found.", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onError(Exception e) {
                runOnUiThread(() -> Toast.makeText(RecyclerViewActivity.this, "Failed to load stars: " + e.getMessage(), Toast.LENGTH_SHORT).show());
                Log.e("RecyclerViewActivity", e.getMessage(), e);
            }
        });
    }
}
