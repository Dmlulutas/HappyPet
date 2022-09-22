package com.example.happypet.view.component

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.happypet.view.theme.darkBlue
import com.example.happypet.view.theme.springGreen

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