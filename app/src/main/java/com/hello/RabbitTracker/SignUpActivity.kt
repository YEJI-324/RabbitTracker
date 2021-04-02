package com.hello.RabbitTracker

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hello.RabbitTracker.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySignupBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.signupBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@SignUpActivity, LogInActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

            startActivity(intent)
            finish()
        })
    }
}