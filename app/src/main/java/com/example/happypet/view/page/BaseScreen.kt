package com.example.happypet.view.page

import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

abstract class BaseScreen() {

    @Composable
    abstract fun GetUI(viewModel: ViewModel, owner: LifecycleOwner)

    abstract var backstack: String?
    abstract var navController: NavHostController


    /*  fun getViewModel(screen: Screen): Any {
          return if (screen == Screen.SettingsScreen) {
              val viewModel = ViewModelProvider(this)[SettingsViewModel::class.java]
              viewModel
          }else{
              val viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
              viewModel
          }
      }*/

}

