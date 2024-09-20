package com.example.finalprodproject.feature_user.domain.helpers

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey


import java.io.IOException
import java.security.GeneralSecurityException

class UserStorageHandler(ctx: Context) {
    private lateinit var encryptedSharedPreferences: EncryptedSharedPreferences

    init {
        try {
            val masterKey: MasterKey = MasterKey.Builder(ctx, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()
            encryptedSharedPreferences = EncryptedSharedPreferences.create(ctx, "user", masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM) as EncryptedSharedPreferences
        } catch (err: IOException) {
            Log.e("auth error", err.message, err)
        } catch (err: GeneralSecurityException) {
            Log.e("auth error", err.message, err)
        }
    }

    fun setToken(token: String) {
        val editor: SharedPreferences.Editor = encryptedSharedPreferences.edit()
        editor.putString("token", token)
        editor.apply()
    }

    fun setProfileData(firstname: String, phone: String, userID: Int) {
        val editor: SharedPreferences.Editor = encryptedSharedPreferences.edit()

        editor.putString("firstname", firstname)
        editor.putString("phone", phone)
        editor.putInt("id", userID)

        editor.apply()
    }

    fun logout() {
        val editor: SharedPreferences.Editor = encryptedSharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    fun getUserID(): Int {
        return encryptedSharedPreferences.getInt("id", 0)
    }

    fun getToken(): String? {
        return encryptedSharedPreferences.getString("token", "")
    }
}