package com.project.recipee

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.ui.setupWithNavController
import com.project.recipee.databinding.ActivityMainBinding
import com.project.recipee.ui.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private val channelId = "001"

    // inisialisasi binding
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        setupBottomNav()
    }

    // set up Bottom navigation
    private fun setupBottomNav() {


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
                R.id.navigation_search
            )
        )
        setupActionBarWithNavController(navHostFragment.navController, appBarConfiguration)

        createNotificationChannel()

        displayNotificationStart()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "countdown", NotificationManager.IMPORTANCE_HIGH).apply {
                description = "Notif when countdown end."
            }
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun displayNotificationStart() {
        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_plate)
            .setContentTitle("Welcome to Recipee")
            .setContentText("Find the best recipe to cook")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)




        with(NotificationManagerCompat.from(this)) {

            // notificationId is a unique int for each notification that you must define

            notify(1, builder.build())

        }
    }
}