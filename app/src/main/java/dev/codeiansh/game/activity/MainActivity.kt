package dev.codeiansh.game.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.github.clans.fab.FloatingActionButton
import dev.codeiansh.game.R
import dev.codeiansh.game.fragments.BottomSheetProfileDialog

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize NavController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        // Initialize UI elements
        val profileBtn: ImageView = findViewById(R.id.profile)
        val homeBtn: FloatingActionButton = findViewById(R.id.homeBtn)
        val appsBtn: FloatingActionButton = findViewById(R.id.appsBtn)
        val gamesBtn: FloatingActionButton = findViewById(R.id.gamesBtn)

        // Set profile button click listener
        profileBtn.setOnClickListener {
            val bottomSheetDialogFragment = BottomSheetProfileDialog()
            bottomSheetDialogFragment.show(supportFragmentManager, BottomSheetProfileDialog.TAG)
        }

        // Set FloatingActionButton click listeners
        homeBtn.setOnClickListener {
            navigateToFragment(R.id.homeFragment)
        }
        appsBtn.setOnClickListener {
            navigateToFragment(R.id.appsFragment)
        }
        gamesBtn.setOnClickListener {
            navigateToFragment(R.id.gameFragment)
        }
    }

    // Define a function to navigate to a specific fragment
    private fun navigateToFragment(destination: Int) {
        val currentFragmentId = navController.currentDestination?.id
        when (destination) {
            R.id.homeFragment -> {
                if (currentFragmentId != R.id.homeFragment) {
                    when (currentFragmentId) {
                        R.id.appsFragment -> navController.navigate(R.id.action_appsFragment_to_homeFragment)
                        R.id.gameFragment -> navController.navigate(R.id.action_gameFragment_to_homeFragment)
                    }
                }
            }
            R.id.appsFragment -> {
                if (currentFragmentId != R.id.appsFragment) {
                    when (currentFragmentId) {
                        R.id.homeFragment -> navController.navigate(R.id.action_homeFragment_to_appsFragment)
                        R.id.gameFragment -> navController.navigate(R.id.action_gameFragment_to_appsFragment)
                    }
                }
            }
            R.id.gameFragment -> {
                if (currentFragmentId != R.id.gameFragment) {
                    when (currentFragmentId) {
                        R.id.homeFragment -> navController.navigate(R.id.action_homeFragment_to_gameFragment)
                        R.id.appsFragment -> navController.navigate(R.id.action_appsFragment_to_gameFragment)
                    }
                }
            }
        }
    }

    @Deprecated("This method has been deprecated!!")
    override fun onBackPressed() {
        val currentFragmentId = navController.currentDestination?.id
        if (currentFragmentId == R.id.homeFragment) {
            showExit()
        } else {
            super.onBackPressed()
        }
    }

    private fun showExit() {
        AlertDialog.Builder(this)
            .setTitle("Exit the store")
            .setMessage("Are you sure you want to exit?")
            .setPositiveButton("Yes") { dialog, _ ->
                dialog.dismiss()
                finish()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
