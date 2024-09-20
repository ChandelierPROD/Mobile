package com.example.finalprodproject.utils.image_loader

import com.example.finalprodproject.utils.Constants

object ChangePathImage {
    fun update(imageURL: String): String {
        if (!imageURL.contains("http://82.97.241.151:8081")) return imageURL

        val changedString = Constants.USER_API_PATH.replace("/api/", "")
        val imageResult: String = imageURL.replace("http://82.97.241.151:8081", changedString)
        return imageResult
    }
}