package com.example.finalprodproject.feature_study_information_page.data.repository

import android.content.Context
import com.example.finalprodproject.common.core.dto.Course
import com.example.finalprodproject.common.network.retrofit.RetrofitClient
import com.example.finalprodproject.feature_user.domain.helpers.UserStorageHandler

class StudyInformationRepository(context: Context) {

    private val token by lazy {
        UserStorageHandler(context).getToken()
    }

    suspend fun getCourseById(id: Int): Course {
        return RetrofitClient.apiCourseInformation.getCourseById(
            authHeader = "Bearer $token",
            id = id
        )
    }

    suspend fun subscribe(id: Int) {
        RetrofitClient.apiCourseInformation.subscribe(
            authHeader = "Bearer $token",
            id = id
        )
    }

}