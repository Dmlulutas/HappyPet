package com.example.happypet.view.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.happypet.R
import com.example.happypet.view.theme.Shapes
import com.example.happypet.view.theme.black100
import com.example.happypet.view.theme.whitesmoke

@Composable
fun PasswordField(
    text: String,
    password: String,
    error: String?,
    onPasswordChange: (String) -> Unit,
) {
    val context = LocalContext.current
    val showPwd = remember { mutableStateOf(false) }

    TextField(
        textStyle = TextStyle(color = whitesmoke),
        modifier = Modifier
            .clip(Shapes.medium)
            .border(2.dp, black100),
        label = {
            Text(
                text = text,
                style = TextStyle(color = whitesmoke)
            )
        },
        value = password,
        visualTransformation = if (showPwd.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = { it -> onPasswordChange(it) },
        isError = error != null,
        trailingIcon = {
            val (icon, iconColor) = if (showPwd.value) {
                Pair(
                    Icons.Filled.Visibility,
                    colorResource(id = R.color.darkBlue)
                )
            } else {
                Pair(Icons.Filled.VisibilityOff, colorResource(id = R.color.white))
            }

            IconButton(onClick = { showPwd.value = !showPwd.value }) {
                Icon(
                    icon,
                    contentDescription = "Visibility",
                    tint = iconColor
                )
            }
        }
    )

    val errorMessage: String = error ?: ""
    Text(text = errorMessage,modifier=Modifier.padding(20.dp), style = TextStyle(color = whitesmoke, textAlign = TextAlign.Left))
}