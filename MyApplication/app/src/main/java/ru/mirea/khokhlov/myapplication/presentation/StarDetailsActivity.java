package ru.mirea.khokhlov.myapplication.presentation;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mirea.khokhlov.myapplication.R;
import ru.mirea.khokhlov.data.network.NetworkClient;
import ru.mirea.khokhlov.data.network.StarApi;
import ru.mirea.khokhlov.domain.models.Star;

public class StarDetailsActivity extends AppCompatActivity {

    private TextView starName, starDescription;
    private ImageView starImage;
    private StarApi starApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_details);

        starName = findViewById(R.id.starName);
        starDescription = findViewById(R.id.starDescription);
        starImage = findViewById(R.id.starImage);

        starApiService = NetworkClient.getRetrofitInstance().create(StarApi.class);

        // Получаем ID звезды из Intent
        int starId = getIntent().getIntExtra("STAR_ID", -1);

        if (starId != -1) {
            fetchStarDetails(starId);
        } else {
            Toast.makeText(this, "Invalid Star ID", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void fetchStarDetails(int starId) {
        starApiService.getStarById(starId).enqueue(new Callback<Star>() {
            @Override
            public void onResponse(Call<Star> call, Response<Star> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Star star = response.body();
                    starName.setText(star.getName());
                    starDescription.setText(star.getDescription());
                    Picasso.get()
                            .load(star.getPhotoUrl())
                            .placeholder(R.drawable.placeholder_image)
                            .error(R.drawable.error_image)
                            .resize(1200, 800)
                            .into(starImage);
                } else {
                    Toast.makeText(StarDetailsActivity.this, "Failed to load star details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Star> call, Throwable t) {
                Toast.makeText(StarDetailsActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

