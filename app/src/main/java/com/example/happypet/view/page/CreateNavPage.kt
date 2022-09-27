package com.example.happypet.view.page

import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

class CreateNavPage(
    override var backstack: String?,
    override var navController: NavHostController,
) : BaseScreen() {


    @Composable
    override fun GetUI(viewModel: ViewModel, owner: LifecycleOwner) {
        TODO("Not yet implemented")
    }

}