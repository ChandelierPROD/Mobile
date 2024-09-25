package com.example.finalprodproject.feature_user.presentation.viewmodels

import android.util.Log

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.finalprodproject.feature_main.data.ThemeDTO
import com.example.finalprodproject.feature_user.data.models.UserDTO
import com.example.finalprodproject.feature_user.data.models.UserProfile
import com.example.finalprodproject.feature_user.domain.helpers.UserStorageHandler
import com.example.finalprodproject.feature_user.domain.repository.UserRepository
import com.example.finalprodproject.utils.enums.LoaderState

import java.io.File

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(
    private val userRepository: UserRepository,
    private val storageHandler: UserStorageHandler,
): ViewModel() {
    private val loaderRegister: MutableLiveData<LoaderState?> = MutableLiveData(null)
    private val loaderLogin: MutableLiveData<LoaderState?> = MutableLiveData(null)
    private val loaderCheckAuth: MutableLiveData<LoaderState> = MutableLiveData(LoaderState.LOADING)
    private val statusCode: MutableLiveData<Int> = MutableLiveData(0)
    private val isAuth: MutableLiveData<Boolean> = MutableLiveData(false)
    private val profile: MutableLiveData<UserProfile> = MutableLiveData(null)
    private val isUpdateProfile: MutableLiveData<LoaderState> = MutableLiveData(null)

    private val token: MutableLiveData<String> = MutableLiveData(null)

    companion object {
        fun provideFactory(newStorageHandler: UserStorageHandler): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val userRepository = UserRepository()

                UserViewModel(userRepository = userRepository, storageHandler = newStorageHandler)
            }
        }
    }

    fun register(phone: String, login: String, password: String) {
        loaderRegister.value = LoaderState.LOADING
        statusCode.value = 0
        userRepository.register(phone, login, password).enqueue(object: Callback<UserDTO> {
            override fun onResponse(call: Call<UserDTO>, response: Response<UserDTO>) {
                statusCode.value = response.code()
                if (response.isSuccessful && response.body() != null) loaderRegister.value = LoaderState.SUCCESS
            }

            override fun onFailure(call: Call<UserDTO>, t: Throwable) {
                Log.e("error_reg", t.message, t)
                loaderRegister.value = LoaderState.ERROR
            }
        })
    }

    fun login(phone: String, password: String) {
        loaderLogin.value = LoaderState.LOADING
        statusCode.value = 0
        userRepository.login(phone, password).enqueue(object: Callback<UserDTO> {
            override fun onResponse(call: Call<UserDTO>, response: Response<UserDTO>) {
                statusCode.value = response.code()
                if (response.isSuccessful && response.body() != null) {
                    storageHandler.setToken(response.body()!!.token)
                    loaderLogin.value = LoaderState.SUCCESS
                }
            }

            override fun onFailure(call: Call<UserDTO>, t: Throwable) {
                Log.e("error_login", t.message, t)
                loaderLogin.value = LoaderState.ERROR
            }
        })
    }

    fun getRegisterLoader(): LiveData<LoaderState?> = loaderRegister

    fun getLoginLoader(): MutableLiveData<LoaderState?> = loaderLogin

    fun getLoaderCheckAuth(): MutableLiveData<LoaderState> = loaderCheckAuth

    fun updateRegisterLoader(loaderState: LoaderState?) {
        loaderRegister.value = loaderState
    }

    fun updateLoginLoader(loaderState: LoaderState?) {
        loaderLogin.value = loaderState
    }

    fun updateCheckAuthLoader(loaderState: LoaderState) {
        loaderCheckAuth.value = loaderState
    }

    fun getStatusCode(): MutableLiveData<Int> = statusCode

    fun updateStatusCode(code: Int) {
        statusCode.value = code
    }

    fun checkAuth(): LiveData<Boolean> {
        loaderCheckAuth.value = (LoaderState.LOADING)
        userRepository.checkAuth(storageHandler.getToken()).enqueue(object: Callback<UserDTO> {
            override fun onResponse(call: Call<UserDTO>, response: Response<UserDTO>) {
                if (response.isSuccessful && response.body() != null) {
                    storageHandler.setProfileData(response.body()!!.firstname, response.body()!!.phone, response.body()!!.id)
                    isAuth.value = true
                } else isAuth.value = false

                loaderCheckAuth.value = LoaderState.SUCCESS
            }

            override fun onFailure(call: Call<UserDTO>, t: Throwable) {
                Log.e("error_auth", t.message, t)
                isAuth.value = false
                loaderCheckAuth.value = LoaderState.ERROR
            }
        })

        return isAuth
    }

    fun getProfile(): LiveData<UserProfile> {
        userRepository.checkAuth(storageHandler.getToken()).enqueue(object: Callback<UserDTO> {
           override fun onResponse(call: Call<UserDTO>, response: Response<UserDTO>) {
                if (response.isSuccessful && response.body() != null) {
                    val userProfile: UserProfile = UserProfile()
                    userProfile.phone = response.body()!!.phone
                    userProfile.password = response.body()?.password ?: ""
                    userProfile.firstname = response.body()?.firstname ?: ""
                    userProfile.lastname = response.body()?.firstname ?: ""
                    userProfile.surname = response.body()?.firstname ?: ""
                    userProfile.id = response.body()!!.id
                    userProfile.image = response.body()?.image ?: ""
                    userProfile.completeThemeIds = response.body()!!.completeThemeIds
                    userProfile.themeIds = response.body()!!.themeIds
                    userProfile.achievement = response.body()!!.achievement

                    userRepository.getUsersThemes(storageHandler.getToken()).enqueue(object: Callback<List<ThemeDTO>> {
                        override fun onResponse(call: Call<List<ThemeDTO>>, response2: Response<List<ThemeDTO>>) {
                            if (response2.isSuccessful && response2.body() != null) {
                                userProfile.themes = response2.body()
                                profile.value = userProfile
                            }
                        }

                        override fun onFailure(call: Call<List<ThemeDTO>>, t: Throwable) {
                            Log.e("error_themes", t.message, t)
                        }
                    })
                }
            }

            override fun onFailure(call: Call<UserDTO>, t: Throwable) {
                Log.e("error_auth", t.message, t)
            }
        })

        return profile
    }

    fun updateProfile(firstname: String, surname: String, lastname: String): LiveData<LoaderState> {
        isUpdateProfile.value = LoaderState.LOADING
        userRepository.updateProfile(storageHandler.getToken(), firstname, surname, lastname).enqueue(object: Callback<UserProfile> {
            override fun onResponse(call: Call<UserProfile>, response: Response<UserProfile>) {
                if (response.isSuccessful && response.body() != null) {
                    profile.value = (response.body())
                    isUpdateProfile.value = (LoaderState.SUCCESS)
                }
            }

            override fun onFailure(call: Call<UserProfile>, t: Throwable) {
                isUpdateProfile.value = (LoaderState.ERROR)
                Log.e("err_profile_update", t.message, t)
            }
        })


        return isUpdateProfile
    }

    fun savePhoto(file: File) {
        userRepository.uploadImage(storageHandler.getToken(), file).enqueue(object: Callback<UserDTO> {
            override fun onResponse(call: Call<UserDTO>, response: Response<UserDTO>) {
                if (response.isSuccessful && response.body() != null) {

                }
            }

            @Override
            override fun onFailure(call: Call<UserDTO>, t: Throwable) {
                Log.e("err_user", t.message, t)
            }
        })
    }
}