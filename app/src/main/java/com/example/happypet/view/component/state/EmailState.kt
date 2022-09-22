package com.example.happypet.view.component.state

import java.util.regex.Pattern

class EmailState:TextFieldState(
    validator = { email-> isValid(email) },
    errorMessage = {err -> getErrorMessage(err)}
)

private val EMAIL_ADDRESS_PATTERN by lazy { "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})" }

fun isValid(email:String):Boolean{
    return  Pattern.matches(EMAIL_ADDRESS_PATTERN,email)
}

private fun getErrorMessage(text:String?):String{
    var msg :String = ""
    msg = if(text!=null && text.isEmpty()){
        "Please enter min 8 character"
    }else{
        "Please enter a value in email format"
    }
    return msg
}