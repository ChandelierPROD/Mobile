package com.example.finalprodproject.ui.activities

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment
import androidx.navigation.NavDestination
import androidx.navigation.fragment.findNavController

import com.example.finalprodproject.R;
import com.example.finalprodproject.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())


        initNavigation()
    }

    private fun initNavigation() {
        val navHostFragment: Fragment = supportFragmentManager.findFragmentById(R.id.nav_host_main_fragment)!!
        navController = navHostFragment.findNavController()
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            NavigationUI.onNavDestinationSelected(item, navController)
            true
        }

        navController.addOnDestinationChangedListener { navController: NavController, navDestination: NavDestination, bundle: Bundle? ->
            if (navController.currentDestination != null) {
                navController.currentDestination.let {
                    if (it?.id == R.id.authFragment) {
                        binding.bottomNavigationView.visibility = View.GONE
                    } else {
                        binding.bottomNavigationView.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

}