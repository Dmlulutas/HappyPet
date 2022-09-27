package com.example.happypet.view.component

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happypet.view.theme.darkwhite
import com.example.happypet.view.theme.gray200
import com.example.happypet.view.theme.springGreen

@Composable
fun AppBar(
    context: Context,
    onNavigationIconClick: () -> Unit,
) {
    val mTitle: String = context.getString(com.example.happypet.R.string.helping_stray_animals)

    TopAppBar(
        title = {
            Text(text = mTitle, fontSize = 24.sp)
        },
        backgroundColor = Color.Black,
        contentColor = darkwhite,
        navigationIcon = {
            IconButton(
                modifier = Modifier.width(30.dp),
                onClick = onNavigationIconClick) {
                Icon(
                    tint = darkwhite,
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Toggle drawer"
                )
            }
        },
        actions = {

            IconButton(
                modifier = Modifier.width(30.dp),
                onClick = {
                    Toast.makeText(context, "Red Alarm", Toast.LENGTH_SHORT).show()
                }) {
                Icon(Icons.Default.Notifications, "Red Alarm", tint = Color.Red)
            }

            IconButton(
                modifier = Modifier.width(30.dp),
                onClick = {
                    Toast.makeText(context, "Green Alarm", Toast.LENGTH_SHORT).show()
                }) {
                Icon(Icons.Default.Notifications, "Green Alarm", tint = springGreen)
            }

        },
    )
}