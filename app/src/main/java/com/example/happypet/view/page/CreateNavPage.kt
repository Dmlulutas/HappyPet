package com.example.happypet.view.page

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

class CreateNavPage(
    override var backstack: String?,
) : BaseScreen() {


    @Composable
    override fun GetUI(viewModel: ViewModel, owner: LifecycleOwner) {
       Text(text = "Create Nav Page")
    }

}