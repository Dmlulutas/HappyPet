package com.example.happypet.ui.page.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.happypet.R
import com.example.happypet.ui.component.state.EmailState
import com.example.happypet.ui.component.state.PasswordState
import com.example.happypet.ui.page.BaseScreen
import com.example.happypet.ui.theme.*
import com.example.happypet.util.Screen
import com.example.happypet.viewModel.HomeViewModel

class LoginPage (
    override var backstack: String?,
    override var navController: NavHostController):
    BaseScreen() {

    @Composable
    override fun GetUI(viewModel: ViewModel,owner: LifecycleOwner) {
        val homeViewModel = viewModel as HomeViewModel

        LoginElements()
        SignUpBtn(){
            navController.navigate(Screen.SignupScreen.route)
        }
    }

    @Composable
    private fun LoginElements(){
        val emailState = remember { EmailState()}
        val pwdState = remember { PasswordState()}

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(darkBlue),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Title()

            EmailField( emailState.text, emailState.error){
                    it->
                emailState.text = it
                emailState.validate()
            }

            PasswordField(pwdState.text,pwdState.error){
                    it->
                pwdState.text = it
                pwdState.validate()
            }

            LoginBtn( btnEnabled = emailState.isValid() && pwdState.isValid()){
                navController.navigate(Screen.HomeScreen.withArgs(emailState.text))
            }

            ForgotPwdBtn(){
                navController.navigate(Screen.ForgotScreen.route)
            }
        }
    }

    @Composable fun Title(){
        Text(
            text = LocalContext.current.getString(R.string.login),
            style = TextStyle(fontSize = 30.sp,color= whitesmoke, fontWeight = FontWeight.ExtraBold))
        Spacer(modifier = Modifier.height(40.dp))
    }

    @Composable fun EmailField(email:String,error:String?, onEmailChanged :(String)->Unit ){
        val context = LocalContext.current

        TextField(
            textStyle = TextStyle(color = whitesmoke),
            modifier = Modifier
                .clip(Shapes.medium)
                .border(2.dp, black100),
            label = {
                Text(
                    text = context.getString(R.string.email),
                    style = TextStyle(color = whitesmoke)
                ) },
            value = email,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { it-> onEmailChanged(it) },
            isError = error != null
        )

        val errorMessage : String = error ?: ""
        Text(text =errorMessage,  style = TextStyle(color = whitesmoke, textAlign = TextAlign.Left))

        Spacer(modifier = Modifier.height(20.dp))
    }

    @Composable fun PasswordField(password : String , error: String?, onPasswordChange:(String)->Unit){
        val context = LocalContext.current
        val showPwd = remember { mutableStateOf(false) }

        TextField(
            textStyle = TextStyle(color = whitesmoke),
            modifier = Modifier
                .clip(Shapes.medium)
                .border(2.dp, black100),
            label = {
                Text(
                    text = context.getString(R.string.password),
                    style = TextStyle(color = whitesmoke)
                ) },
            value = password,
            visualTransformation = if(showPwd.value) {VisualTransformation.None} else {PasswordVisualTransformation()},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = {it-> onPasswordChange(it) },
            isError = error!=null
        )

        val errorMessage : String = error ?: ""
        Text(text = errorMessage,  style = TextStyle(color = whitesmoke, textAlign = TextAlign.Left))

        Spacer(modifier = Modifier.height(20.dp))
    }

    @Composable
    private fun LoginBtn(btnEnabled :Boolean, onClick:()->Unit){

        Box(modifier = Modifier.padding(50.dp, 0.dp, 50.dp, 0.dp)) {
            Button(
                shape = RoundedCornerShape(50.dp),
                enabled =btnEnabled,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(Shapes.medium)
                    .border(2.dp, black100, RoundedCornerShape((50.dp))),
                onClick = { onClick() },
            ) {
                Text(text = LocalContext.current.getString(R.string.login))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }

    @Composable
    private fun ForgotPwdBtn(onClick: () -> Unit) {
        ClickableText(
            text = AnnotatedString(LocalContext.current.getString(R.string.forgot_question)),
            style = TextStyle(
                fontSize = 14.sp,
                color= darkwhite
            ),
            onClick = { onClick() },
        )
    }

    @Composable
    private fun SignUpBtn(onClick: () -> Unit){
        Box(modifier = Modifier.fillMaxSize()) {
            ClickableText(
                text = AnnotatedString(LocalContext.current.getString(R.string.signup_here)),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp),
                onClick = { onClick()},
                style = TextStyle(
                    fontSize = 14.sp,
                    textDecoration = TextDecoration.Underline,
                    color = springGreen
                )
            )
        }
    }


}

