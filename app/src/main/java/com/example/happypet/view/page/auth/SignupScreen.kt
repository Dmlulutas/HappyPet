package com.example.happypet.view.page.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.happypet.R
import com.example.happypet.view.page.BaseScreen
import com.example.happypet.view.theme.Shapes
import com.example.happypet.view.theme.black100
import com.example.happypet.view.theme.darkBlue
import com.example.happypet.view.theme.whitesmoke
import com.example.happypet.util.Screen
import com.example.happypet.viewModel.HomeViewModel

class SignupPage(
    override var backstack: String?,
    override var navController: NavHostController,
) : BaseScreen() {

    @Composable
    override fun GetUI(viewModel: ViewModel,owner: LifecycleOwner) {
        val homeViewModel = viewModel as HomeViewModel
        Box(modifier = Modifier.fillMaxSize()) {
            ScaffoldWithTopBar()
        }
    }

    @Composable
    private fun ScaffoldWithTopBar() {
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(darkBlue),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val email = remember { mutableStateOf(TextFieldValue()) }
            val password = remember { mutableStateOf(TextFieldValue()) }
            val confirmPassword = remember { mutableStateOf(TextFieldValue()) }

            Text(text = context.getString(R.string.signup),
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.ExtraBold))

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                placeholder = { Text(context.getString(R.string.email)) },
                textStyle = TextStyle(color = whitesmoke),
                modifier = Modifier
                    .clip(Shapes.medium)
                    .border(1.dp, black100),
                label = {
                    Text(
                        text = context.getString(R.string.email),
                        style = TextStyle(color = whitesmoke)
                    )
                },
                value = email.value,
                onValueChange = { email.value = it })

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier
                    .clip(Shapes.medium)
                    .border(2.dp, black100),
                textStyle = TextStyle(color = whitesmoke),
                label = {
                    Text(
                        text = context.getString(R.string.password),
                        style = TextStyle(color = whitesmoke)
                    )
                },
                value = password.value,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { password.value = it })

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier
                    .clip(Shapes.medium)
                    .border(2.dp, black100),
                label = {
                    Text(
                        text = context.getString(R.string.confirm_password),
                        style = TextStyle(color = whitesmoke)
                    )
                },
                textStyle = TextStyle(color = whitesmoke),
                value = confirmPassword.value,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { confirmPassword.value = it })

            Spacer(modifier = Modifier.height(20.dp))


            Signup(emailField = email.value.text)
        }


    }

    @Composable
    private fun Signup(emailField: String) {
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(Shapes.medium)
                    .border(2.dp, black100, RoundedCornerShape((50.dp))),
                onClick = { navController.navigate(Screen.HomeScreen.withArgs(emailField)) },
            ) {
                Text(text = LocalContext.current.getString(R.string.signup))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }

}

