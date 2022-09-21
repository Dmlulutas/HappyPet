package com.example.happypet.ui.page

import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import com.example.happypet.util.Screen
import com.example.happypet.viewModel.HomeViewModel
import com.example.happypet.viewModel.SettingsViewModel
import kotlin.properties.ReadOnlyProperty

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

