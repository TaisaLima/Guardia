package com.example.guardi.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.guardi.database.AppDataBase
import com.example.guardi.databinding.ActivityLoginBinding
import com.example.guardi.models.User
import java.util.UUID

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {ActivityLoginBinding.inflate(layoutInflater)}
    private val userDao by lazy {AppDataBase.instantiate(this).userDao()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.appLogo.load("https://i.ibb.co/8mQvBt6/image.png")
        loginConfig()
        signUpConfig()
    }

    private fun loginConfig() {
        val button = binding.loginButton

        button.setOnClickListener {
            val email = binding.emailEditText.toString()
            val password = binding.passwordEditText.toString()

            userDao.getUserByCredentials(email, password)
            finish()
        }
    }

    private fun signUpConfig() {
        val button = binding.signUpButton
        button.setOnClickListener {
            val email = binding.emailEditText.toString()
            val password = binding.passwordEditText.toString()

            val user = User(UUID.randomUUID().toString(), email, password, "82999223510", "11485296343")
            userDao.add(user)
            finish()
        }
    }
}