package ru.mirea.khokhlov.myapplication.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import ru.mirea.khokhlov.data.database.StarDatabase;
import ru.mirea.khokhlov.data.repository.StarRepositoryImpl;
import ru.mirea.khokhlov.domain.usecases.GetFavoriteStarUseCase;
import ru.mirea.khokhlov.domain.usecases.SaveStarToFavoriteUseCase;
import ru.mirea.khokhlov.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private Button btnOpenStarList, toLogin;
    private TextView tvWelcome;


    private GetFavoriteStarUseCase getFavoriteStarUseCase;
    private SaveStarToFavoriteUseCase saveStarToFavoriteUseCase;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StarRepositoryImpl repository = new StarRepositoryImpl(StarDatabase.getInstance(this).starDao());

        // Создание ViewModel через фабрику
        MainViewModelFactory factory = new MainViewModelFactory(repository);
        mainViewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);

        btnOpenStarList = findViewById(R.id.openRecyclerView);
        toLogin = findViewById(R.id.toLogin);
        tvWelcome = findViewById(R.id.tvWelcome);

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new StarAdapter();
//        recyclerView.setAdapter(adapter);

        // Firebase Authentication
        firebaseAuth = FirebaseAuth.getInstance();

        // Проверяем авторизацию
        checkAuthentication();

        // Логика кнопки "Open Star List"
//        btnOpenStarList.setOnClickListener(v -> {
//            btnOpenStarList.setVisibility(View.GONE);
//            mainViewModel.loadStars();
//        });

        toLogin.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });

        btnOpenStarList.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
            finish();
        });
    }

    private void checkAuthentication() {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        if (currentUser == null) {
            // Пользователь не авторизован
            startActivity(new Intent(MainActivity.this, RecyclerView.class));
            finish();
        } else {
            // Пользователь авторизован
            tvWelcome.setVisibility(View.VISIBLE);
            tvWelcome.setText("Welcome, " + currentUser.getEmail() + "!");
            btnOpenStarList.setVisibility(View.VISIBLE);

            // Инициализация ViewModel
            StarRepositoryImpl repository = new StarRepositoryImpl(StarDatabase.getInstance(this).starDao());
            MainViewModelFactory factory = new MainViewModelFactory(repository);
            mainViewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);

            mainViewModel.getErrorLiveData().observe(this, error -> {
                // Обработка ошибки
            });
        }
    }

//    private void saveStar(Star star) {
//        // Сохраняем звезду в базу данных
//        new Thread(() -> {
//            boolean success = saveStarToFavoriteUseCase.execute(star); // Сохраняем звезду
//
//            // Обновляем UI в основном потоке
//            runOnUiThread(() -> {
//                if (success) {
//                    Toast.makeText(MainActivity.this, "Star saved successfully!", Toast.LENGTH_SHORT).show();
//                    loadStars(); // Перезагружаем список звёзд
//                } else {
//                    Toast.makeText(MainActivity.this, "Failed to save star.", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }).start();
//    }
}