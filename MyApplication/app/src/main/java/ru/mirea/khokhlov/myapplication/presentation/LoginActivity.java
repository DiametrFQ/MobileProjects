package ru.mirea.khokhlov.myapplication.presentation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.khokhlov.myapplication.R;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText emailInput = findViewById(R.id.emailInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);

        // Инициализация ViewModel
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        // Подписка на успешный логин
        loginViewModel.getLoginResult().observe(this, result -> {
            if (result.isSuccess()) {
                saveEmailToSharedPreferences(result.getEmail());
                Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("user_email", result.getEmail());
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Error: " + result.getErrorMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Подписка на успешную регистрацию
        loginViewModel.getRegisterResult().observe(this, success -> {
            if (success) {
                Toast.makeText(LoginActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LoginActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
            }
        });

        // Обработчик нажатия кнопки логина
        loginButton.setOnClickListener(view -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "No data", Toast.LENGTH_SHORT).show();
                return;
            }
            loginViewModel.login(email, password);
        });

        // Обработчик нажатия кнопки регистрации
        registerButton.setOnClickListener(view -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "No data", Toast.LENGTH_SHORT).show();
                return;
            }
            loginViewModel.register(email, password);
        });
    }

    private void saveEmailToSharedPreferences(String email) {
        SharedPreferences sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_email", email);
        editor.apply();
    }
}
