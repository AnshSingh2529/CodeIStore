package dev.codeiansh.game.activity

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.github.clans.fab.FloatingActionButton
import com.github.clans.fab.FloatingActionMenu
import com.google.android.material.appbar.MaterialToolbar
import dev.codeiansh.game.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize NavController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        // Initialize UI elements
        val profile: FloatingActionButton = findViewById(R.id.profile)
        val menuBtn: MaterialToolbar = findViewById(R.id.menuBtn)
        val drawer: DrawerLayout = findViewById(R.id.drawer)
        val floatingMenu: FloatingActionMenu = findViewById(R.id.FloatingActionMenu)
        val homeBtn: FloatingActionButton = findViewById(R.id.homeBtn)
        val appsBtn: FloatingActionButton = findViewById(R.id.appsBtn)
        val gamesBtn: FloatingActionButton = findViewById(R.id.gamesBtn)

        // Set navigation drawer button click listener
        menuBtn.setNavigationOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }

        profile.setOnClickListener{
          val dialog = object: Dialog(this){


          }
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
}
