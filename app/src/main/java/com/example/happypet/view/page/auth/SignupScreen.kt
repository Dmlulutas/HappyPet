package com.example.happypet.view.page.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.happypet.R
import com.example.happypet.util.Screen
import com.example.happypet.view.component.ConditionalButton
import com.example.happypet.view.component.EmailField
import com.example.happypet.view.component.PasswordField
import com.example.happypet.view.component.Title
import com.example.happypet.view.page.BaseScreen
import com.example.happypet.view.page.auth.state.EmailState
import com.example.happypet.view.page.auth.state.PasswordState
import com.example.happypet.view.theme.darkBlue
import com.example.happypet.viewModel.HomeViewModel

class SignupPage(
    override var backstack: String?,
    override var navController: NavHostController,
) : BaseScreen() {

    @Composable
    override fun GetUI(viewModel: ViewModel, owner: LifecycleOwner) {
        val homeViewModel = viewModel as HomeViewModel
        SignupElements()
    }

    @Composable
    private fun SignupElements() {
        val context = LocalContext.current

        val emailState = remember { EmailState() }
        val pwdState = remember { PasswordState() }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(darkBlue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title(text = context.getString(R.string.signup))
            EmailField(emailState.text, emailState.error) { it ->
                emailState.text = it
                emailState.validate()
            }

            PasswordField(LocalContext.current.getString(R.string.password),pwdState.text, pwdState.error) { it ->
                pwdState.text = it
                pwdState.validate()
            }

            PasswordField(LocalContext.current.getString(R.string.confirm_password),pwdState.text, pwdState.error) { it ->
                pwdState.text = it
                pwdState.validate()
            }


            ConditionalButton(
                text = LocalContext.current.getString(R.string.signup),
                enableCondition = emailState.isValid() && pwdState.isValid()) {
                navController.navigate(Screen.HomeScreen.withArgs(emailState.text))
            }

        }

    }


}
