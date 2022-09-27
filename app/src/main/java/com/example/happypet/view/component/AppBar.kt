package com.example.happypet.view.component

import android.content.Context
import android.widget.Toast
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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

            ExtendedFloatingActionButton(
                onClick = onNavigationIconClick,
                icon = {
                    Icon(
                        Icons.Filled.Warning,
                        contentDescription = "Red Alarm",
                        tint = Color.Red
                    )
                },
                text = {}
            )


            ExtendedFloatingActionButton(
                onClick = onNavigationIconClick,
                icon = {
                    Icon(
                        Icons.Filled.Warning,
                        contentDescription = "Green Alarm",
                        tint = springGreen
                    )
                },
                text = {}
            )

        },
    )
}