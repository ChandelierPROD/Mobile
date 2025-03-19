package com.example.finalprodproject.feature_user.data.api

import com.example.finalprodproject.feature_main.data.ThemeDTO
import com.example.finalprodproject.feature_user.data.models.UserDTO
import com.example.finalprodproject.feature_user.data.models.UserProfile


import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part

interface UserAPI {
    @POST("auth/register")
    fun register(@Body userDTO: UserDTO): Call<UserDTO>

    @POST("auth/sign-in")
    fun login(@Body userDTO: UserDTO): Call<UserDTO>

    @GET("me/profile")
    fun checkAuth(@Header("Authorization") token: String): Call<UserDTO>

    @GET("themes/me")
    fun getUsersThemes(@Header("Authorization") token: String): Call<List<ThemeDTO>>

    @GET("themes/complete")
    fun getUsersCompleteThemes(@Header("Authorization") token: String): Call<List<ThemeDTO>>

    @PATCH("me/setProfile")
    fun profileUpdate(@Header("Authorization") token: String, @Body userProfile: UserDTO): Call<UserProfile>

    @Multipart
    @POST("me/addImage")
    fun uploadPhoto(@Header("Authorization") token: String, @Part file: MultipartBody.Part): Call<UserDTO>
}
