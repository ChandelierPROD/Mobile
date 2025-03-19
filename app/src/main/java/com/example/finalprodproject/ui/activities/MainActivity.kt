package com.example.finalprodproject.ui.activities

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI

import android.os.Bundle;
import android.view.View;
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

import com.example.finalprodproject.R;
import com.example.finalprodproject.databinding.ActivityMainBinding
import com.example.finalprodproject.feature_user.domain.helpers.UserStorageHandler
import com.example.finalprodproject.feature_user.presentation.viewmodels.UserViewModel
import com.example.finalprodproject.utils.enums.LoaderState

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var userViewModel: UserViewModel
    private lateinit var navHostFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())

        val userViewModel: UserViewModel by viewModels() { UserViewModel.provideFactory( UserStorageHandler(applicationContext)) }
        this.userViewModel = userViewModel

        initNavigation()

        userViewModel.checkAuth();

        userViewModel.getLoaderCheckAuth().observe(this, { loaderState ->
            when (loaderState) {
                LoaderState.LOADING -> {
                    //navHostFragment.findNavController().navigate(R.id.authFragment)
                }
                LoaderState.SUCCESS -> {
                    navHostFragment.findNavController().navigate(R.id.shopFragment)

                }
                LoaderState.ERROR -> {
                    navHostFragment.findNavController().navigate(R.id.authFragment)
                }
            }
        });
    }

    private fun initNavigation() {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_main_fragment)!!
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