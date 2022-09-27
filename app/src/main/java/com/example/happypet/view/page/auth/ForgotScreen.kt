package com.example.happypet.view.page.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.happypet.R
import com.example.happypet.model.enums.Screen
import com.example.happypet.view.component.ConditionalButton
import com.example.happypet.view.component.EmailField
import com.example.happypet.view.component.Title
import com.example.happypet.view.page.auth.state.EmailState
import com.example.happypet.view.page.BaseScreen
import com.example.happypet.view.theme.darkBlue
import com.example.happypet.viewModel.HomeViewModel

class ForgotPage(
    override var backstack: String?,
    override var navController: NavHostController,
) : BaseScreen() {


    @Composable
    override fun GetUI(viewModel: ViewModel, owner: LifecycleOwner) {
        val homeViewModel = viewModel as HomeViewModel
        ForgotElements()
    }

    @Composable
    fun ForgotElements() {
        val emailState = remember { EmailState() }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(darkBlue),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Title(LocalContext.current.getString(R.string.forgot))
            EmailField(emailState.text, emailState.error) { it ->
                emailState.text = it
                emailState.validate()
            }

            ConditionalButton(text = LocalContext.current.getString(R.string.forgot),
                enableCondition = emailState.isValid()) {
                navController.navigate(Screen.LoginScreen.withArgs(emailState.text))
            }
        }

    }
}
