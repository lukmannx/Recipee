package com.project.recipee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.recipee.R
import androidx.navigation.ui.setupWithNavController
import com.project.recipee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // inisialisasi binding
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        setupBottomNav()
    }

    // set up Bottom navigation
    private fun setupBottomNav() {
        supportActionBar?.hide()

        // hubungin dgn bottomNavigationview yg dari xml
        val navView: BottomNavigationView = binding.navView

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navView.setupWithNavController(navHostFragment.navController)

        // konfigurasi appbar
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                // id fragment yg masuk appbar
                R.id.navigation_home,
                R.id.navigation_saved
            )
        )
        setupActionBarWithNavController(navHostFragment.navController, appBarConfiguration)
    }
}