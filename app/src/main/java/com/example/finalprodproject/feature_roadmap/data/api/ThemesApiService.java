package com.example.finalprodproject.feature_roadmap.data.api;

import com.example.finalprodproject.feature_user.data.api.RetrofitBuilder;
import com.example.finalprodproject.utils.Constants;

public class ThemesApiService {
    private final ThemesAPI themesAPI;

    public ThemesApiService() {
        themesAPI = RetrofitBuilder.Companion.getInstance(Constants.USER_API_PATH).create(ThemesAPI.class);
    }

    public ThemesAPI getThemeAPI() {
        return themesAPI;
    }
}