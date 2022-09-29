package com.example.happypet.view.page.auth

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.happypet.R
import com.example.happypet.model.enums.Screen
import com.example.happypet.view.AuthActivity
import com.example.happypet.view.MainActivity
import com.example.happypet.view.component.ConditionalButton
import com.example.happypet.view.component.EmailField
import com.example.happypet.view.component.PasswordField
import com.example.happypet.view.component.Title
import com.example.happypet.view.page.BaseScreen
import com.example.happypet.view.page.auth.state.EmailState
import com.example.happypet.view.page.auth.state.PasswordState
import com.example.happypet.view.theme.darkBlue
import com.example.happypet.view.theme.darkwhite
import com.example.happypet.view.theme.springGreen
import com.example.happypet.viewModel.AuthViewModel

class LoginPage(
    var owner: AuthActivity,
    override var backstack: String?,
    var navController: NavHostController,
) :
    BaseScreen() {

    @Composable
    override fun GetUI(viewModel: ViewModel, owner: LifecycleOwner) {
        val authViewModel = viewModel as AuthViewModel

        LoginElements()
        SignUpBtn() {
            navController.navigate(Screen.SignupScreen.route)
        }

    }

    @Composable
    private fun LoginElements() {
        val emailState = remember { EmailState() }
        val pwdState = remember { PasswordState() }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(darkBlue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Title(LocalContext.current.getString(R.string.login))

            EmailField(emailState.text, emailState.error) { it ->
                emailState.text = it
                emailState.validate()
            }

            PasswordField(LocalContext.current.getString(R.string.password),
                pwdState.text,
                pwdState.error) { it ->
                pwdState.text = it
                pwdState.validate()
            }

            ConditionalButton(text = LocalContext.current.getString(R.string.login),
                //enableCondition = true
                enableCondition = emailState.isValid() && pwdState.isValid()
            ) {

                val context = owner
                val intent = Intent(owner, MainActivity::class.java)
                context.startActivity(intent)
                // navController.navigate(Screen.HomeScreen.withArgs(emailState.text))
            }

            ForgotPwdBtn() {
                navController.navigate(Screen.ForgotScreen.route)
            }
        }
    }

    @Composable
    private fun ForgotPwdBtn(onClick: () -> Unit) {
        ClickableText(
            text = AnnotatedString(LocalContext.current.getString(R.string.forgot_question)),
            style = TextStyle(
                fontSize = 14.sp,
                color = darkwhite
            ),
            onClick = { onClick() },
        )
    }

    @Composable
    private fun SignUpBtn(onClick: () -> Unit) {
        Box(modifier = Modifier.fillMaxSize()) {
            ClickableText(
                text = AnnotatedString(LocalContext.current.getString(R.string.signup_here)),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp),
                onClick = { onClick() },
                style = TextStyle(
                    fontSize = 14.sp,
                    textDecoration = TextDecoration.Underline,
                    color = springGreen
                )
            )
        }
    }

}

