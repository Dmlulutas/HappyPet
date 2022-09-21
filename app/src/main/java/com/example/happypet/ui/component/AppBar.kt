package com.example.happypet.ui.component

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.happypet.ui.theme.darkBlue
import com.example.happypet.ui.theme.darkGreen
import com.example.happypet.ui.theme.springGreen

@Composable
fun AppBar(
    context: Context,
    onNavigationIconClick: () -> Unit,
) {
    val mTitle: String = context.getString(com.example.happypet.R.string.helping_stray_animals)

    TopAppBar(
        title = {
            Text(text = mTitle)
        },
        backgroundColor = darkBlue,
        contentColor = springGreen,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Toggle drawer"
                )
            }
        },
        actions = {
            // Creating Icon button favorites, on click
            // would create a Toast message
            IconButton(
                onClick = {
                    Toast.makeText(context, "Alerts", Toast.LENGTH_SHORT).show()
                }) {
                Icon(Icons.Default.Notifications, "Alerts", tint = Color.Red)
            }

        },
    )
}