package dev.codeiansh.game

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuBtn: MaterialToolbar = findViewById(R.id.menuBtn)
        val drawer: androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.drawer)

        menuBtn.setNavigationOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }

    }
}