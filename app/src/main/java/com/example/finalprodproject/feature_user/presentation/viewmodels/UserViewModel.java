package com.example.finalprodproject.feature_user.presentation.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.finalprodproject.feature_main.data.ThemeDTO;
import com.example.finalprodproject.feature_user.data.models.UserDTO;
import com.example.finalprodproject.feature_user.data.models.UserProfile;
import com.example.finalprodproject.feature_user.domain.helpers.UserStorageHandler;
import com.example.finalprodproject.feature_user.domain.repository.UserRepository;
import com.example.finalprodproject.utils.enums.LoaderState;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends AndroidViewModel {
    private final MutableLiveData<LoaderState> loaderRegister = new MutableLiveData<>(null);
    private final MutableLiveData<LoaderState> loaderLogin = new MutableLiveData<>(null);
    private final MutableLiveData<LoaderState> loaderCheckAuth = new MutableLiveData<>(LoaderState.LOADING);
    private final MutableLiveData<Integer> statusCode = new MutableLiveData<>(0);
    private final UserRepository userRepository;
    private final UserStorageHandler storageHandler;
    private final MutableLiveData<Boolean> isAuth = new MutableLiveData<>(false);
    private final MutableLiveData<UserProfile> profile = new MutableLiveData<>();


    public UserViewModel(@NonNull Application application, UserStorageHandler storageHandler, UserRepository userRepository) {
        super(application);

        this.storageHandler = storageHandler;
        this.userRepository = userRepository;
    }

    public void register(String email, String login, String password) {
        loaderRegister.setValue(LoaderState.LOADING);
        statusCode.setValue(0);
        userRepository.register(email, login, password).enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(@NonNull Call<UserDTO> call, @NonNull Response<UserDTO> response) {
                statusCode.setValue(response.code());
                if (response.isSuccessful() && response.body() != null) loaderRegister.setValue(LoaderState.SUCCESS);
            }

            @Override
            public void onFailure(@NonNull Call<UserDTO> call, @NonNull Throwable t) {
                Log.e("error_reg", t.getMessage(), t);
                loaderRegister.setValue(LoaderState.ERROR);
            }
        });
    }

    public void login(String login, String password) {
        loaderLogin.setValue(LoaderState.LOADING);
        statusCode.setValue(0);
        userRepository.login(login, password).enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(@NonNull Call<UserDTO> call, @NonNull Response<UserDTO> response) {
                statusCode.setValue(response.code());
                if (response.isSuccessful() && response.body() != null) {
                    storageHandler.setToken(response.body().getToken());
                    loaderLogin.setValue(LoaderState.SUCCESS);
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserDTO> call, @NonNull Throwable t) {
                Log.e("error_login", t.getMessage(), t);
                loaderLogin.setValue(LoaderState.ERROR);
            }
        });
    }

    public LiveData<LoaderState> getRegisterLoader() { return loaderRegister; }

    public MutableLiveData<LoaderState> getLoginLoader() {
        return loaderLogin;
    }

    public MutableLiveData<LoaderState> getLoaderCheckAuth() {
        return loaderCheckAuth;
    }

    public void updateRegisterLoader(LoaderState loaderState) {
        loaderRegister.setValue(loaderState);
    }

    public void updateLoginLoader(LoaderState loaderState) {
        loaderLogin.setValue(loaderState);
    }

    public void updateCheckAuthLoader(LoaderState loaderState) {
        loaderCheckAuth.setValue(loaderState);
    }

    public MutableLiveData<Integer> getStatusCode() {
        return statusCode;
    }

    public void updateStatusCode(int code) {
        statusCode.setValue(code);
    }

    public LiveData<Boolean> checkAuth() {
        loaderCheckAuth.setValue(LoaderState.LOADING);
        userRepository.checkAuth(storageHandler.getToken()).enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(@NonNull Call<UserDTO> call, @NonNull Response<UserDTO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    storageHandler.setProfileData(response.body().getLogin(), response.body().getEmail(), response.body().getId());
                    isAuth.setValue(true);
                } else isAuth.setValue(false);

                loaderCheckAuth.setValue(LoaderState.SUCCESS);
            }

            @Override
            public void onFailure(@NonNull Call<UserDTO> call, @NonNull Throwable t) {
                Log.e("error_auth", t.getMessage(), t);
                isAuth.setValue(false);
                loaderCheckAuth.setValue(LoaderState.ERROR);
            }
        });

        return isAuth;
    }

    public LiveData<UserProfile> getProfile() {
        userRepository.checkAuth(storageHandler.getToken()).enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(@NonNull Call<UserDTO> call, @NonNull Response<UserDTO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    UserProfile userProfile = new UserProfile();
                    userProfile.setEmail(response.body().getEmail());
                    userProfile.setPassword(response.body().getPassword());
                    userProfile.setLogin(response.body().getLogin());
                    userProfile.setId(response.body().getId());
                    userProfile.setRoles(response.body().getRoles());
                    userProfile.setCompleteThemeIds(response.body().getCompleteThemeIds());
                    userProfile.setThemeIds(response.body().getThemeIds());

                    userRepository.getUsersThemes(storageHandler.getToken()).enqueue(new Callback<List<ThemeDTO>>() {
                        @Override
                        public void onResponse(@NonNull Call<List<ThemeDTO>> call, @NonNull Response<List<ThemeDTO>> response2) {
                            if (response2.isSuccessful() && response2.body() != null) {
                                userProfile.setThemes(response2.body());
                                profile.setValue(userProfile);
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<List<ThemeDTO>> call, @NonNull Throwable t) {
                            Log.e("error_themes", t.getMessage(), t);
                        }
                    });
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserDTO> call, @NonNull Throwable t) {
                Log.e("error_auth", t.getMessage(), t);
            }
        });

        return profile;
    }

}