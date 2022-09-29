package com.example.happypet.util

import SettingsPage
import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.happypet.R
import com.example.happypet.model.enums.Screen
import com.example.happypet.view.AuthActivity
import com.example.happypet.view.MainActivity
import com.example.happypet.view.page.CreateNavPage
import com.example.happypet.view.page.HomeScreen
import com.example.happypet.viewModel.CreateNavViewModel
import com.example.happypet.viewModel.HomeViewModel
import com.example.happypet.viewModel.SettingsViewModel

@Composable
fun MainNavigation(owner: MainActivity, navController: NavHostController) {
    //val arguments = createUserArgument("userId", "no_user")
    NavHost(navController, startDestination = Screen.HomeScreen.route) {
        val homeViewModel = ViewModelProvider(owner)[HomeViewModel::class.java]
        val settingsViewModel =
            ViewModelProvider(owner)[SettingsViewModel::class.java]
        val createNavViewModel =
            ViewModelProvider(owner)[CreateNavViewModel::class.java]

        composable(
            Screen.HomeScreen.route
            // route = Screen.HomeScreen.route + "/{userId}",
            //arguments = arguments
        ) { navBackStack ->
            //val backStack = navBackStack.arguments?.get("userId").toString()
            HomeScreen(null).GetUI(homeViewModel, owner)
        }

        composable(Screen.SettingsScreen.route) {
            SettingsPage(null).GetUI(settingsViewModel, owner)
        }

        composable(Screen.CreateNavigation.route) {
            CreateNavPage(null).GetUI(createNavViewModel, owner)
        }


    }

    fun createUserArgument(name: String, value: Any): List<NamedNavArgument> {
        val mainScreenArguments = listOf(navArgument(name) {
            type = NavType.StringType
            nullable = true
            defaultValue = value
        })
        return mainScreenArguments
    }
}


