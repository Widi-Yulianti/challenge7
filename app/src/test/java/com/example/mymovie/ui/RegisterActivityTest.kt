package com.example.mymovie.ui

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class RegisterActivityTest {

    private lateinit var register: RegisterActivity

    @Before
    fun setUp(){
        register = RegisterActivity()
    }

    @Test
    fun name_exist() {
        val result = register.validateRegistrationActivityInput("shawn","shawn","123456","123456", "20", "toronto")
        assertEquals("name exist",result,false)
    }

    @Test
    fun username_exist() {
        val result = register.validateRegistrationActivityInput("peter","peter","123456","123456", "20", "toronto")
        assertEquals("username exist",result,false)
    }

    @Test
    fun name_empty() {
        val result = register.validateRegistrationActivityInput("","raul","123456","123456", "20", "toronto")
        assertEquals("name empty",result,false)
    }

    @Test
    fun password_kurang() {
        val result = register.validateRegistrationActivityInput("mendes","","12345","12345", "20", "toronto")
        assertEquals("password < 6",result,false)
    }

    @Test
    fun password_lebih() {
        val result = register.validateRegistrationActivityInput("shawny","shawny","123453121212121212121212121212121212121212121212121212121212123213231123","123453121212121212121212121212121212121212121212121212121212123213231123", "20", "toronto")
        assertEquals("password > 50",result,false)
    }


    @Test
    fun address_empty() {
        val result = register.validateRegistrationActivityInput("raul","raul","123456","", "20", "")
        assertEquals("address empty",result,false)
    }
}