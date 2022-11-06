package com.example.mymovie.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mymovie.R
import com.example.mymovie.databinding.ActivityRegisterBinding
import com.example.mymovie.model.ViewModelUser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    private val existUsername = listOf<String>("shawn","peter","raul","mendes")
    private val existName = listOf<String>("shawn","peter","raul","mendes")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRegistration.setOnClickListener {
            val name = binding.etName.text.toString()
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            val repeatPassword = binding.etRepeatPassword.text.toString()

            var age = ""
            var address = ""

            if (password == repeatPassword) {
                addUser(name,username,password,age, address)
                startActivity(Intent(this, LoginActivity::class.java))
            } else if (password != repeatPassword) {
                Toast.makeText(this, "Password wrong", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun addUser(name: String,
                        username: String,
                        password: String,
                        age: String,
                        address: String) {
        val viewModel = ViewModelProvider(this)[ViewModelUser::class.java]
        viewModel.callPostUser(name,username, password,age,address)
        viewModel.postLiveDataUser().observe(this) {
            if (it != null) {
                Toast.makeText(this, "Succesed", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }

    fun validateRegistrationActivityInput(
        name: String,
        username: String,
        password: String,
        repeatPassword: String,
        age: String,
        address: String
    ): Boolean {
        if (name.isEmpty() || username.isEmpty() || password.isEmpty() || age.isEmpty() || address.isEmpty()){
            return false
        }

        if (username in existUsername) {
            return false
        }

        if (password.length < 6) {
            false
        }

        if (password.length > 50) {
            false
        }
        if (password != repeatPassword){
            return false
        }

        if (address in existName) {
            return false
        }

        return true
    }
}