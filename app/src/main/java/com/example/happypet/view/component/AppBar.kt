package com.example.happypet.view.component

import android.content.Context
import android.widget.Toast
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.happypet.model.AlertType
import com.example.happypet.model.enums.Screen
import com.example.happypet.view.theme.gold
import com.example.happypet.view.theme.springGreen

@Composable
fun AppBar(
    context: Context,
    navController: NavHostController,
    onNavigationIconClick: () -> Unit,
) {
    val mTitle: String = context.getString(com.example.happypet.R.string.helping_stray_animals)

    TopAppBar(
        title = {
            Text(text = mTitle, fontSize = 22.sp)
        },
        backgroundColor = Color.Black,
        contentColor = gold,
        navigationIcon = {
            IconButton(
                modifier = Modifier.width(35.dp),
                onClick = onNavigationIconClick) {
                Icon(
                    tint = gold,
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Toggle drawer"
                )
            }
        },
        actions = {

            IconButton(
                modifier = Modifier.width(30.dp),
                onClick = {
                    navController.navigate(Screen.CreateNavigation.withArgs(AlertType.Red.toString()))
                }) {
                Icon(Icons.Default.Notifications, "Red Alarm", tint = Color.Red)
            }

            IconButton(
                modifier = Modifier.width(30.dp),
                onClick = {
                    navController.navigate(Screen.CreateNavigation.withArgs(AlertType.Green.toString()))
                }) {
                Icon(Icons.Default.Notifications, "Green Alarm", tint = springGreen)
            }

        },
    )
}