package com.example.mymovie

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.mymovie.databinding.ActivitySplashBinding
import com.example.mymovie.datastore.DataStoreManager
import com.example.mymovie.model.LoginViewModel
import com.example.mymovie.model.ViewModelFactory
import com.example.mymovie.ui.LoginActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var pref: DataStoreManager
    private lateinit var viewModelLoginPref: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = this.getSharedPreferences(
            "datauser",
            Context.MODE_PRIVATE
        )
        pref = DataStoreManager(this)
        viewModelLoginPref = ViewModelProvider(this, ViewModelFactory(pref))[LoginViewModel::class.java]
        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            viewModelLoginPref.getUser().observe(this, {
                if (it.username == "" && it.password == "") {
                    startActivity(Intent(this, LoginActivity::class.java))
                } else {
                    startActivity(Intent(this, MainActivity::class.java))
                }
            })
        }, 3000)

    }
}