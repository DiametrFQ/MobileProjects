package ru.mirea.khokhlov.myapplication.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.khokhlov.myapplication.R;
import ru.mirea.khokhlov.myapplication.data.repository.StarRepositoryImpl;
import ru.mirea.khokhlov.myapplication.domains.models.Star;
import ru.mirea.khokhlov.myapplication.domains.repository.MovieRepository;
import ru.mirea.khokhlov.myapplication.domains.usecases.GetFavoriteStarUseCase;
import ru.mirea.khokhlov.myapplication.domains.usecases.SaveStarToFavoriteUseCase;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.textInputStar);
        TextView textView = findViewById(R.id.starName);
        MovieRepository movieRepository = new StarRepositoryImpl(this);

        findViewById(R.id.saveStar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean result = new SaveStarToFavoriteUseCase(movieRepository).execute(new Star(2, text.getText().toString()));
                textView.setText(String.format("Save result %s", result));
            }
        });
        findViewById(R.id.showStar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Star moview = new GetFavoriteStarUseCase(movieRepository).execute();
                textView.setText(String.format("Save result %s", moview.getName()));
            }
        });
    }
}