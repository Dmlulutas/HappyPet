package com.example.happypet.view.page.auth.state

import java.util.regex.Pattern

class PasswordState: TextFieldState(
    validator  = {text-> pwdValidate(text)},
    errorMessage = { text -> errorMessage(text)}
) {

}

private val PWD_PATTERN by lazy { "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$" }

private fun pwdValidate(text:String) :Boolean{
    return Pattern.matches(PWD_PATTERN,text)
}

private fun errorMessage (text: String?) : String{
    var message : String = ""
    if(Pattern.matches( PWD_PATTERN,text )){
        message = "Please enter at least one special character, number, letter and min 8 characters"
    }
    return message
}
