package com.example.happypet.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.happypet.view.theme.darkBlue
import kotlinx.coroutines.launch

@Composable
fun DrawerMenu(onMenuItemClick: () -> Unit) {
    val context = LocalContext.current;
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val bodyModifier: Modifier = Modifier
        .background(darkBlue)
        .fillMaxSize()
    Scaffold(
        Modifier.fillMaxSize(),

        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                context = context,
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawer().DrawerHeader()
            NavigationDrawer().DrawerBody(
                items = listOf(
                    MenuItem(
                        id = TabbarItems.HOME,
                        title = "Home",
                        contentDescription = "Go to home screen",
                        icon = Icons.Default.Home
                    ),
                    MenuItem(
                        id = TabbarItems.SETTINGS,
                        title = "Settings",
                        contentDescription = "Go to settings screen",
                        icon = Icons.Default.Settings
                    ),
                    MenuItem(
                        id = TabbarItems.HELP,
                        title = "Help",
                        contentDescription = "Get help",
                        icon = Icons.Default.Info
                    ),
                ),
                bodyModifier,
                onItemClick = {
                    if (it.id == TabbarItems.SETTINGS) {
                        onMenuItemClick()
                    }

                }
            )
        }
    ) {
        //MainPage(null)
    }

}
