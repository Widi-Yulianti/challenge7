package com.example.mymovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mymovie.databinding.ActivityMainBinding
import com.example.mymovie.movies.MovieFragment
import com.example.mymovie.movies.MovieFragment.Companion.getFragmentTag
import com.example.mymovie.movies.MoviesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MoviesFragment())
                .commit()
        }

//        Toast.makeText(this, BuildConfig.BASE_URL, Toast.LENGTH_LONG).show()

    }


    fun navigateMovieView() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MovieFragment())
            .addToBackStack(MovieFragment.getFragmentTag())
            .commitAllowingStateLoss()
    }

}