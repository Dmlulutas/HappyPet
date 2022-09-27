package com.example.happypet.util

import SettingsPage
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.happypet.model.enums.Screen
import com.example.happypet.view.page.HomeScreen
import com.example.happypet.view.page.auth.ForgotPage
import com.example.happypet.view.page.auth.LoginPage
import com.example.happypet.view.page.auth.SignupPage
import com.example.happypet.view.MainActivity
import com.example.happypet.view.page.CreateNavPage
import com.example.happypet.viewModel.CreateNavViewModel
import com.example.happypet.viewModel.HomeViewModel
import com.example.happypet.viewModel.SettingsViewModel

@Composable
fun Navigation(owner: MainActivity) {
    val navController = rememberNavController()
    val arguments = createUserArgument("userId", "no_user")

    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {

        val homeViewModel = ViewModelProvider(owner)[HomeViewModel::class.java]
        val settingsViewModel = ViewModelProvider(owner)[SettingsViewModel::class.java]
        val createNavViewModel =ViewModelProvider(owner)[CreateNavViewModel::class.java]

        composable(
            route = Screen.HomeScreen.route + "/{userId}",
            arguments = arguments
        ) { navBackStack ->
            val backStack = navBackStack.arguments?.get("userId").toString()
            HomeScreen(backStack, navController)
                .GetUI(homeViewModel,owner)
        }

        composable(Screen.LoginScreen.route) {
            LoginPage(null, navController).GetUI(homeViewModel,owner)
        }

        composable(Screen.ForgotScreen.route) {
            ForgotPage(null, navController).GetUI(homeViewModel,owner)
        }

        composable(Screen.SignupScreen.route) {
            SignupPage(null, navController).GetUI(homeViewModel,owner)
        }

        composable(Screen.SettingsScreen.route) {
            SettingsPage(null, navController).GetUI(settingsViewModel,owner)
        }

        composable(Screen.CreateNavigation.route) {
            CreateNavPage(null, navController).GetUI(createNavViewModel,owner)
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


