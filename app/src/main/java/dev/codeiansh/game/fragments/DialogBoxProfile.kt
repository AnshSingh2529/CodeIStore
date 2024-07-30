package dev.codeiansh.game.fragments

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import dev.codeiansh.game.R
import dev.codeiansh.game.activity.LoginActivity

class BottomSheetProfileDialog : BottomSheetDialogFragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_profile, container, false)

        // Use shared preferences to get the username and email and show it in the User's profile
        val sharedPreferences = view.context.getSharedPreferences("UserData", MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "")
        val email = sharedPreferences.getString("email", "")

        val userUsername = view.findViewById<TextView>(R.id.user_username)
        val usersEmail = view.findViewById<TextView>(R.id.users_email)

        userUsername.text = username
        usersEmail.text = email

        // User's profile buttons functionality
        val cancelBtn = view.findViewById<ImageButton>(R.id.cancelBtn)
        val profileChange = view.findViewById<CardView>(R.id.profileChange)
        val accountSetupBtn = view.findViewById<TextView>(R.id.account_setup_btn)
        val managingBtn = view.findViewById<TextView>(R.id.managing_btn)
        val notifyBtn = view.findViewById<TextView>(R.id.notify_btn)
        val paymentsBtn = view.findViewById<TextView>(R.id.payments_btn)
        val privacyPolicyBtn = view.findViewById<TextView>(R.id.privacy_policy_btn)
        val libraryBtn = view.findViewById<TextView>(R.id.library_btn)
        val appPassBtn = view.findViewById<TextView>(R.id.app_pass_btn)
        val pointsBtn = view.findViewById<TextView>(R.id.points_btn)
        val settingsBtn = view.findViewById<TextView>(R.id.settings_btn)
        val helpFeedbackBtn = view.findViewById<TextView>(R.id.help_feedback_btn)
        val privacyPolicy = view.findViewById<TextView>(R.id.privacy_policy)
        val signOutBtn = view.findViewById<Button>(R.id.signOut_btn)

        firebaseAuth = FirebaseAuth.getInstance()

        signOutBtn.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(view.context, LoginActivity::class.java))
            dismiss()
            activity?.finish()

        }

        cancelBtn.setOnClickListener {
            dismiss()
        }

        profileChange.setOnClickListener {
            // Add functionality for profile change
        }
        accountSetupBtn.setOnClickListener {
            // Add functionality for account setup
        }

        managingBtn.setOnClickListener {
            // Add functionality for managing
        }

        notifyBtn.setOnClickListener {
            // Add functionality for notifications
        }
        paymentsBtn.setOnClickListener {
            // Add functionality for payments
        }

        privacyPolicyBtn.setOnClickListener {
            // Add functionality for privacy policy
        }
        libraryBtn.setOnClickListener {
            // Add functionality for library
        }
        appPassBtn.setOnClickListener {
            // Add functionality for app password
        }
        pointsBtn.setOnClickListener {
            // Add functionality for points
        }
        settingsBtn.setOnClickListener {
            // Add functionality for settings
        }
        helpFeedbackBtn.setOnClickListener {
            // Add functionality for help and feedback
        }
        privacyPolicy.setOnClickListener {
            // Add functionality for privacy policy
        }

        // Return the view
        return view
    }

    companion object {
        const val TAG = "BottomSheetProfileDialog"
    }
}
