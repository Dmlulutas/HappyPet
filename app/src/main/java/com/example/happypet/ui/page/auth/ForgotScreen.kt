package com.example.happypet.ui.page.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.happypet.R
import com.example.happypet.ui.component.CustomTopAppBar
import com.example.happypet.ui.page.BaseScreen
import com.example.happypet.viewModel.HomeViewModel

class ForgotPage(
    override var backstack: String?,
    override var navController: NavHostController
): BaseScreen() {


    @Composable
    override fun GetUI(viewModel: ViewModel,owner: LifecycleOwner) {
        val homeViewModel = viewModel as HomeViewModel
        Box(modifier = Modifier.fillMaxSize()) {
            ScaffoldWithTopBarForgotPass()
        }
    }

    @Composable
    private fun ScaffoldWithTopBarForgotPass() {
        val context = LocalContext.current
        Scaffold(
            topBar = {
                CustomTopAppBar(navController, "Forgot Password", true)
            }, content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = context.getString(R.string.forgot),
                        fontSize = 30.sp,
                        color = Color.Black
                    )
                }
            })
    }



}
