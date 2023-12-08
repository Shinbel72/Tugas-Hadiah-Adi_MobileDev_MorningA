package com.example.adi_mobiledev_morning_a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adi_mobiledev_morning_a.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val user = User(binding.etUsername.text.toString(), binding.etPassword.text.toString())
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("User", user)
            startActivity(intent)
        }
    }
}