package ru.mirea.khokhlov.myapplication.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.mirea.khokhlov.domain.AuthRepository;
import ru.mirea.khokhlov.data.FirebaseAuthRepository;
import ru.mirea.khokhlov.domain.usecases.LoginUseCase;
import ru.mirea.khokhlov.domain.usecases.RegisterUseCase;

public class LoginViewModel extends ViewModel {

    private final MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private final MutableLiveData<Boolean> registerResult = new MutableLiveData<>();

    private final LoginUseCase loginUseCase;
    private final RegisterUseCase registerUseCase;

    public LoginViewModel() {
        AuthRepository authRepository = new FirebaseAuthRepository();
        this.loginUseCase = new LoginUseCase(authRepository);
        this.registerUseCase = new RegisterUseCase(authRepository);
    }

    public LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public LiveData<Boolean> getRegisterResult() {
        return registerResult;
    }

    public void login(String email, String password) {
        loginUseCase.execute(email, password, new AuthRepository.AuthCallback() {
            @Override
            public void onSuccess() {
                loginResult.postValue(new LoginResult(true, email, null));
            }

            @Override
            public void onError(String errorMessage) {
                loginResult.postValue(new LoginResult(false, null, errorMessage));
            }
        });
    }

    public void register(String email, String password) {
        registerUseCase.execute(email, password, new AuthRepository.AuthCallback() {
            @Override
            public void onSuccess() {
                registerResult.postValue(true);
            }

            @Override
            public void onError(String errorMessage) {
                registerResult.postValue(false);
            }
        });
    }

    public static class LoginResult {
        private final boolean success;
        private final String email;
        private final String errorMessage;

        public LoginResult(boolean success, String email, String errorMessage) {
            this.success = success;
            this.email = email;
            this.errorMessage = errorMessage;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getEmail() {
            return email;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
