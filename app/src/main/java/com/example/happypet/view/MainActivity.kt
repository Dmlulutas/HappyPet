package com.example.happypet.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.zIndex
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.happypet.model.MenuItem
import com.example.happypet.model.enums.Screen
import com.example.happypet.model.enums.TabbarItems
import com.example.happypet.util.MainNavigation
import com.example.happypet.view.component.AppBar
import com.example.happypet.view.component.NavigationDrawer
import com.example.happypet.view.theme.HomePageTheme
import com.example.happypet.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = ViewModelProvider(this@MainActivity)[HomeViewModel::class.java]

        setContent {
            MainScreen()
        }

    }

    @Composable
    fun MainScreen() {

        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        val navController = rememberNavController()

        HomePageTheme {
            Surface {
                val context = LocalContext.current;

                Scaffold(
                    Modifier
                        .fillMaxSize()
                        .zIndex(10f),
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
                        DrawerContent(scope,
                            scaffoldState,
                            navController = navController)
                    }
                ) {

                    MainNavigation(this@MainActivity, navController = navController)

                }

            }
        }
    }


    @Composable
    private fun DrawerContent(
        scope: CoroutineScope,
        scaffoldState: ScaffoldState,
        navController: NavHostController,
    ) {
        val bodyModifier: Modifier = Modifier
            .zIndex(8f)
            .fillMaxSize()

        NavigationDrawer().DrawerHeader()
        NavigationDrawer().DrawerBody(
            items = getDrawerMenuItems(),
            bodyModifier,
            onItemClick = { drawerItemOnClick(it, scope, scaffoldState, navController) }
        )
    }

    private fun getDrawerMenuItems(): List<MenuItem> {
        return listOf(
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
                id = TabbarItems.CREATENAVPAGE,
                title = "Create Nav Page",
                contentDescription = "Go to create nav screen",
                icon = Icons.Default.Add
            ),

            )
    }

    private fun drawerItemOnClick(
        it: MenuItem,
        scope: CoroutineScope,
        scaffoldState: ScaffoldState,
        navController: NavHostController,
    ) {
        scope.launch {
            scaffoldState.drawerState.close()
        }
        when (it.id) {
            TabbarItems.HOME -> navController.navigate(Screen.HomeScreen.route)
            TabbarItems.SETTINGS -> navController.navigate(Screen.SettingsScreen.route)
            TabbarItems.CREATENAVPAGE -> navController.navigate(Screen.CreateNavigation.route)
        }

    }

}







