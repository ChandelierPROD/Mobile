package com.example.finalprodproject.feature_user.data.api.dto;

import com.example.finalprodproject.feature_user.data.models.UserDTO;
import com.google.gson.annotations.SerializedName;

data class RegisterUserDTO(
    @SerializedName("profile")
    private var userDTO: UserDTO?
)
