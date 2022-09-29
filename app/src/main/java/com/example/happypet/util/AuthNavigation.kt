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
import com.example.happypet.view.AuthActivity
import com.example.happypet.view.page.CreateNavPage
import com.example.happypet.view.page.auth.ForgotPage
import com.example.happypet.view.page.auth.LoginPage
import com.example.happypet.view.page.auth.SignupPage
import com.example.happypet.viewModel.AuthViewModel
import com.example.happypet.viewModel.CreateNavViewModel
import com.example.happypet.viewModel.SettingsViewModel

@Composable
fun AuthNavigation(owner: AuthActivity) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {

        val authViewModel = ViewModelProvider(owner)[AuthViewModel::class.java]

        composable(Screen.LoginScreen.route) {
            LoginPage(owner, null, navController).GetUI(authViewModel, owner)
        }

        composable(Screen.ForgotScreen.route) {
            ForgotPage(null, navController).GetUI(authViewModel, owner)
        }

        composable(Screen.SignupScreen.route) {
            SignupPage(null, navController).GetUI(authViewModel, owner)
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


