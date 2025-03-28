package com.example.finalprodproject.feature_roadmap.domain;

import com.example.finalprodproject.feature_main.data.ThemeDTO;
import com.example.finalprodproject.feature_roadmap.data.api.ThemesAPI;
import com.example.finalprodproject.feature_roadmap.data.api.ThemesApiService;
import com.example.finalprodproject.feature_roadmap.data.models.TaskModel;
import com.example.finalprodproject.feature_roadmap.data.models.UnderTheme;
import com.example.finalprodproject.feature_shop.data.models.Category;
import com.example.finalprodproject.feature_shop.data.models.CourseShopModel;
import com.example.finalprodproject.feature_user.data.api.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class ThemesRepository {
    public ThemesAPI themesAPI;

    public ThemesRepository() {
        themesAPI = new ThemesApiService().getThemeAPI();
    }

    public Call<ThemeDTO> getThemeByID(String token, int id) {
        return themesAPI.getThemeById("Bearer " + token, id);
    }

    public Call<UnderTheme> setMark(String token, int id, int mark) {
        return themesAPI.setMark("Bearer " + token, id, mark);
    }

    public Call<List<Category>> getCategories(String token) {
        return themesAPI.getCategories("Bearer " + token);
    }

    public Call<List<CourseShopModel>> getProducts(String token) {
        return themesAPI.getProducts("Bearer " + token);
    }

    public Call<CourseShopModel> buyProduct(String token, int id) {
        return themesAPI.buyProduct("Bearer " + token, id);
    }

    public Call<UnderTheme> getByUnderTheme(String token, int id) {
        return themesAPI.getByUnderTheme("Bearer " + token, id);
    }

    public Call<List<TaskModel>> getTasksList(String token, int id) {
        return themesAPI.getTasksList("Bearer " + token, id);
    }
}
