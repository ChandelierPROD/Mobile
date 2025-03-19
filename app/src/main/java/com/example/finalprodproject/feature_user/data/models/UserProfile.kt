package com.example.finalprodproject.feature_user.data.models;

import com.example.finalprodproject.feature_main.data.ThemeDTO;

class UserProfile() : UserDTO() {
    public lateinit var themes: List<ThemeDTO>

    //constructor(login: String, email: String, password: String, id: Int, token: String): super(login=login, email=email, password=password, id=id, token=token)

}
