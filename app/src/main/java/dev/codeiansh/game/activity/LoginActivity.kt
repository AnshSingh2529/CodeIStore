package dev.codeiansh.game.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import dev.codeiansh.game.R

class LoginActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBtn: Button = findViewById(R.id.login_Button)
        val loginEmail: EditText = findViewById(R.id.login_email)
        val loginPassword: EditText = findViewById(R.id.login_password)
        val loginSignup: TextView = findViewById(R.id.login_Signup)
        val loginChecked: CheckBox = findViewById(R.id.login_checked)

        firebaseAuth = FirebaseAuth.getInstance()
        val sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        loginSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
        loginPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.length >= 8 || count >= 8 || start >= 8) {
                    loginChecked.isClickable = true
                    loginChecked.isChecked = true
                    loginBtn.isClickable = true
                } else {
                    loginChecked.isChecked = false
                    loginChecked.isClickable = false
                    loginBtn.isClickable = false
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        loginBtn.setOnClickListener {
            val email = loginEmail.text.toString()
            val password = loginPassword.text.toString()

            if (email.isNotBlank() && password.isNotBlank()) {
                if (password.length >= 8) {
                    if (loginChecked.isChecked) { // Check if the checkbox is checked
                        firebaseAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val user = firebaseAuth.currentUser
                                    val username = user?.displayName ?: ""

                                    val editor = sharedPreferences.edit()
                                    editor.putString("email", email)
                                    editor.putString("username", username)
                                    editor.apply()
                                    val intent = Intent(this, MainActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        this,
                                        "Authentication failed: ${task.exception?.message}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    } else {
                        Toast.makeText(
                            this, "Please agree to the terms and conditions.", Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this, "Password must be at least 8 characters!", Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    this, "Please fill all the fields!", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
