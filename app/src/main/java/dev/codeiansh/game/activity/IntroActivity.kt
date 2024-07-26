package dev.codeiansh.game.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import dev.codeiansh.game.R

class IntroActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val introBtn: Button = findViewById(R.id.IntroBtn)
        firebaseAuth = FirebaseAuth.getInstance()

        introBtn.setOnClickListener {
            if (firebaseAuth.currentUser == null) {
                startActivity(Intent(this, SignupActivity::class.java))
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }
            finish()
        }
    }
}
