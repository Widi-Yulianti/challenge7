package com.example.mymovie.ui

import org.junit.Assert.*
import org.junit.Test

class ProfileFragmentTest {

    private lateinit var profile: ProfileFragment

    @Test
    fun password_kurang() {
        val result = profile.validateProfileFragmentInput("mendes","","12345","12345", "20", "toronto")
        assertEquals("password < 6",result,false)
    }

    @Test
    fun password_lebih() {
        val result = profile.validateProfileFragmentInput("shawny","shawny","123453121212121212121212121212121212121212121212121212121212123213231123","123453121212121212121212121212121212121212121212121212121212123213231123", "20", "toronto")
        assertEquals("password > 50",result,false)
    }
}