package com.example.happypet.ui.component.state

import java.util.regex.Pattern

class EmailState:TextFieldState(
    validator = { email-> isValid(email) },
    errorMessage = {err -> getErrorMessage(err)}
){
}

private val EMAIL_ADDRESS_PATTERN ="^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"

fun isValid(email:String):Boolean{
    return  Pattern.matches(EMAIL_ADDRESS_PATTERN,email)
}

private fun getErrorMessage(text:String?):String{
    var msg :String = ""
    if(text!=null && text.length==0){
        msg = "Please enter min 8 character"
    }else{
        msg= "Please enter a value in email format"
    }
    return msg
}