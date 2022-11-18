package com.example.mymovie.ui

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class LoginActivityTest {
    private lateinit var login: LoginActivity

    @Before
    fun setUp(){
        login = LoginActivity()
    }

    @After
    fun tearDown(){
    }

    @Test
    fun username_exist() {
        val result = login.validateLoginActivityInput("peter","123456")
        assertEquals("username exist",result,false)
    }

    @Test
    fun password_kurang() {
        val result = login.validateLoginActivityInput("mendes", "12345")
        assertEquals("password < 6", result, false)
    }
}