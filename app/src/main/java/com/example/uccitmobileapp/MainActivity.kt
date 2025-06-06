package com.example.uccitmobileapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.uccitmobileapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    //Called when the activity is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setup the toolbar as the activity's action bar
        setSupportActionBar(binding.appBarMain.toolbar)

        drawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

//Obtain the navigationController to manage fragments navigation
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        //Define top-level destinations that should not display the "up" button
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_faculty,
                R.id.nav_courses,
                R.id.nav_admissions,
                R.id.nav_social
            ),
            drawerLayout
        )

        //Setup the action bar witht eh navigation controller and bind NavigationView to work with the navigation controller
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener(this)

        // Setup the Floating Action Button (FAB) to send an email
        binding.appBarMain.fab.setOnClickListener { view ->
            sendEmailToHOD(view)
        }
    }

    //Inflate menu for Action Bar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    //Handle the "up" button navigation
    override fun onSupportNavigateUp(): Boolean {
        val navController = (supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment).navController
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    //Navigation item selection
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val navController = (supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment).navController

        return when (item.itemId) {
            R.id.nav_social -> {
                navController.navigate(R.id.nav_social)
                drawerLayout.closeDrawers()
                true
            }


            else -> {
                val handled = NavigationUI.onNavDestinationSelected(item, navController)
                if (handled) drawerLayout.closeDrawers()
                handled
            }
        }
    }

    //Function to send an email to th Head of Department (HOD)
    private fun sendEmailToHOD(view: android.view.View) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:hod@ucc.edu.jm")
            putExtra(Intent.EXTRA_SUBJECT, "Inquiry from UCC IT App")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Snackbar.make(view, "No email app found.", Snackbar.LENGTH_SHORT).show()
        }
    }
//Function to open an external link in the browser
    private fun openExternalLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Snackbar.make(binding.root, "No app found to open this link.", Snackbar.LENGTH_SHORT).show()
        }
    }
}
