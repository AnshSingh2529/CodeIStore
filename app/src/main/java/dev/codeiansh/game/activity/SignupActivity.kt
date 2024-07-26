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

class SignupActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var signupPassword: EditText
    private lateinit var signupChecked: CheckBox
    private lateinit var signupBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        firebaseAuth = FirebaseAuth.getInstance() // Initialize FirebaseAuth

        signupBtn = findViewById(R.id.signup_button)
        val signupEmail: EditText = findViewById(R.id.signup_email)
        val signupFirstName: EditText = findViewById(R.id.signup_firstName)
        signupPassword = findViewById(R.id.signup_password)
        signupChecked = findViewById(R.id.signup_checked)
        val signupLogin: TextView = findViewById(R.id.signup_Login)

        signupLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        // Helper function to validate the form
        fun validateForm() {
            val passwordValid = signupPassword.text.length >= 8
            val checkBoxChecked = signupChecked.isChecked
            signupBtn.isEnabled = passwordValid && checkBoxChecked
        }

        // Set up a TextWatcher to monitor changes in the password field
        signupPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validateForm()
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        // Set up a listener for the CheckBox
        signupChecked.setOnCheckedChangeListener { _, _ ->
            validateForm()
        }

        signupBtn.setOnClickListener {
            val username = signupFirstName.text.toString()
            val email = signupEmail.text.toString()
            val password = signupPassword.text.toString()

            if (username.isNotBlank() && email.isNotBlank() && password.isNotBlank()) {
                if (password.length >= 8) {
                    if (signupChecked.isChecked) { // Check if the checkbox is checked
                        firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val editor = sharedPreferences.edit()
                                    editor.putString("username", username)
                                    editor.putString("email", email)
                                    editor.apply()

                                    val intent = Intent(this, LoginActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        this, "Authentication failed: ${task.exception?.message}", Toast.LENGTH_SHORT
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
