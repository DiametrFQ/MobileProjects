package ru.mirea.khokhlov.myapplication.presentation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.khokhlov.myapplication.R;
import ru.mirea.khokhlov.myapplication.data.repository.FirebaseAuthRepository;
import ru.mirea.khokhlov.myapplication.domains.usecases.LoginUseCase;
import ru.mirea.khokhlov.myapplication.domains.usecases.RegisterUseCase;

import ru.mirea.khokhlov.domain.;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText emailInput = findViewById(R.id.emailInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);

        FirebaseAuthRepository authRepository = new FirebaseAuthRepository();
        LoginUseCase loginUseCase = new LoginUseCase(authRepository);
        RegisterUseCase registerUseCase = new RegisterUseCase(authRepository);

        loginButton.setOnClickListener(view -> {
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();
            loginUseCase.execute(email, password, new AuthRepository.AuthCallback() {
                @Override
                public void onSuccess() {
                    Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(String errorMessage) {
                    Toast.makeText(LoginActivity.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
                }
            });
        });

        registerButton.setOnClickListener(view -> {
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();
            registerUseCase.execute(email, password, new AuthRepository.AuthCallback() {
                @Override
                public void onSuccess() {
                    Toast.makeText(LoginActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(String errorMessage) {
                    Toast.makeText(LoginActivity.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
