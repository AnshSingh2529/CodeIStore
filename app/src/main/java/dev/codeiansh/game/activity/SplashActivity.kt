package dev.codeiansh.game.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import dev.codeiansh.game.R

class SplashActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        firebaseAuth = FirebaseAuth.getInstance()

        val delayMillis: Long = 3000 // Delay duration in milliseconds
        if (firebaseAuth.currentUser == null) {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, IntroActivity::class.java)
                startActivity(intent)
                finish()
            }, delayMillis)
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
