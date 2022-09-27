package com.example.happypet.view.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.happypet.R
import com.example.happypet.view.theme.Shapes
import com.example.happypet.view.theme.black100
import com.example.happypet.view.theme.whitesmoke

@Composable
fun EmailField(email: String, error: String?, onEmailChanged: (String) -> Unit) {
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
            )
        },
        value = email,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = { it -> onEmailChanged(it) },
        isError = error != null
    )

    val errorMessage: String = error ?: ""
    Text(text = errorMessage, style = TextStyle(color = whitesmoke, textAlign = TextAlign.Left))

    Spacer(modifier = Modifier.height(20.dp))
}

