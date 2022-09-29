package com.example.happypet.util

import SettingsPage
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.happypet.model.enums.Screen
import com.example.happypet.view.MainActivity
import com.example.happypet.view.page.CreateNavPage
import com.example.happypet.view.page.HomeScreen
import com.example.happypet.viewModel.CreateNavViewModel
import com.example.happypet.viewModel.HomeViewModel
import com.example.happypet.viewModel.SettingsViewModel
import androidx.navigation.navArgument
import androidx.navigation.NavType
import androidx.navigation.NamedNavArgument

@Composable
fun MainNavigation(owner: MainActivity, navController: NavHostController) {
    val arguments = createUserArgument("userId", "no_user")
    NavHost(navController, startDestination = Screen.HomeScreen.route) {
        val homeViewModel = ViewModelProvider(owner)[HomeViewModel::class.java]
        val settingsViewModel =
            ViewModelProvider(owner)[SettingsViewModel::class.java]
        val createNavViewModel =
            ViewModelProvider(owner)[CreateNavViewModel::class.java]

        composable(
            Screen.HomeScreen.route) {
            HomeScreen(null).GetUI(homeViewModel, owner)
        }

        composable(Screen.SettingsScreen.route) {
            SettingsPage(null).GetUI(settingsViewModel, owner)
        }

        composable(
            route = Screen.CreateNavigation.route + "/{alertType}",
            arguments = arguments
        ) {
            val navStack = it.arguments?.get("alertType").toString()
            CreateNavPage(navStack).GetUI(createNavViewModel, owner)
        }

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


