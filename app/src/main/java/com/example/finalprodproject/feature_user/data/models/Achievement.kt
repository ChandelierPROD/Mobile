package com.example.finalprodproject.feature_user.data.models

import com.google.gson.annotations.SerializedName

data class Achievement(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("isCompleted")
    val isCompleted: Boolean,

    @SerializedName("image")
    val image: String
)
