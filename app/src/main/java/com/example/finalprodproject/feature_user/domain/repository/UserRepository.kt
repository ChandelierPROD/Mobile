package com.example.finalprodproject.feature_user.domain.repository

import com.example.finalprodproject.feature_main.data.ThemeDTO
import com.example.finalprodproject.feature_user.data.api.UserAPI
import com.example.finalprodproject.feature_user.data.api.UserApiService
import com.example.finalprodproject.feature_user.data.models.UserDTO
import com.example.finalprodproject.feature_user.data.models.UserProfile

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import java.io.File

class UserRepository {
    private val userAPI: UserAPI = UserApiService().getUserAPI()

    fun register(phone: String, firstname: String, password: String): Call<UserDTO> = userAPI.register(UserDTO(phone, firstname, password))

    fun login(phone: String, password: String): Call<UserDTO> = userAPI.login(UserDTO(phone, password))

    fun checkAuth(token: String): Call<UserDTO> = userAPI.checkAuth("Bearer " + token)
    
    fun getUsersThemes(token: String): Call<List<ThemeDTO>> = userAPI.getUsersThemes("Bearer " + token)

    fun getUsersCompletedThemes(token: String): Call<List<ThemeDTO>> = userAPI.getUsersCompleteThemes("Bearer " + token)

    fun updateProfile(token: String, firstname: String, surname: String, lastname: String): Call<UserProfile> {
        val userData = UserDTO()
        userData.firstname = firstname
        userData.lastname = lastname
        userData.surname = surname

        return userAPI.profileUpdate("Bearer " + token, userData)
    }

    fun uploadImage(token: String, photo: File): Call<UserDTO> {
//        val fileReqBody: RequestBody = RequestBody.create(MediaType.parse("multipart/form-data"), photo)
        val fileReqBody: RequestBody = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), photo)
        val file: MultipartBody.Part = MultipartBody.Part.createFormData("file", photo.getName(), fileReqBody)

        return userAPI.uploadPhoto("Bearer " + token, file)
    }
}
