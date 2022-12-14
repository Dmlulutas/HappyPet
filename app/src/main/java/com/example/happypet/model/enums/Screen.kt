package com.example.happypet.model.enums

sealed class Screen(val route:String){
    object HomeScreen : Screen("home_screen")
    object SettingsScreen : Screen("settings_screen")
    object CreateNavigation: Screen("create_navigation")
    object LoginScreen : Screen("login")
    object ForgotScreen: Screen("forgot")
    object SignupScreen: Screen("signup")

    fun withArgs(vararg args:String):String{
        return  buildString {
      append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}
