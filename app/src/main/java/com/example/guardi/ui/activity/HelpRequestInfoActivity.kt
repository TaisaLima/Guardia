package com.example.guardi.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.guardi.databinding.ActivityHelpRequestInfoBinding

class HelpRequestInfoActivity : AppCompatActivity() {

    private val binding by lazy {ActivityHelpRequestInfoBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.appLogo.load("https://i.ibb.co/7zDN3BM/image.png")

        binding.cancelButton.setOnClickListener {
            finish()
        }
    }
}