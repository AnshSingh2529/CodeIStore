package dev.codeiansh.game.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import dev.codeiansh.game.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        val sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)
        val email = sharedPreferences.getString("email", "")

        val delayMillis: Long = 3000 // Delay duration in milliseconds

        if (email.isNullOrEmpty()) {
            // If no email found, navigate to IntroActivity after delay
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, IntroActivity::class.java)
                startActivity(intent)
                finish()
            }, delayMillis)
        } else {
            // If email is found, navigate to MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
