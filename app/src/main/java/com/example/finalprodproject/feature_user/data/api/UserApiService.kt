package com.example.finalprodproject.feature_user.data.api;

import com.example.finalprodproject.utils.Constants;
import retrofit2.create

class UserApiService {
    private val userAPI: UserAPI = RetrofitBuilder.Companion.getInstance(Constants.USER_API_PATH).create()
    fun getUserAPI(): UserAPI = userAPI
}