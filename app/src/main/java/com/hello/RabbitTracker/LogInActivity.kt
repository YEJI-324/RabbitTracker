package com.hello.RabbitTracker

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hello.RabbitTracker.databinding.ActivityLoginBinding

class LogInActivity :AppCompatActivity(){

    private var backPressedTime: Long = 0

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_RabbitTracker)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding?.loginBtn?.setOnClickListener {
            val intent = Intent(this@LogInActivity, MainActivity::class.java)
            intent.flags = FLAG_ACTIVITY_CLEAR_TOP

            startActivity(intent)
            finish()
        }

        binding?.moveSignupBtn?.setOnClickListener{
            val intent = Intent(this@LogInActivity, SignUpActivity::class.java)
            intent.flags = FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - backPressedTime >= 2000) {
            backPressedTime = System.currentTimeMillis()
            Toast.makeText(applicationContext, "한 번 더 누르면 종료", Toast.LENGTH_SHORT).show()
        }
        else {
            finish()
        }
    }
}