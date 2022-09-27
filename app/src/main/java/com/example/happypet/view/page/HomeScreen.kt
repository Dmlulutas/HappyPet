package com.example.happypet.view.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.zIndex
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.happypet.model.Character
import com.example.happypet.model.MenuItem
import com.example.happypet.util.Screen
import com.example.happypet.view.component.AppBar
import com.example.happypet.view.component.CharacterList
import com.example.happypet.view.component.NavigationDrawer
import com.example.happypet.view.component.TabbarItems
import com.example.happypet.viewModel.HomeViewModel
import kotlinx.coroutines.launch

class HomeScreen(
    override var backstack: String?,
    override var navController: NavHostController,
) : BaseScreen() {

    lateinit var homeViewModel: HomeViewModel
    lateinit var owner: LifecycleOwner

    @Composable
    override fun GetUI(viewModel: ViewModel, owner: LifecycleOwner) {
        // Toast.makeText(LocalContext.current, "email $backstack", Toast.LENGTH_LONG).show()

        homeViewModel = viewModel as HomeViewModel
        this.owner = owner

        val context = LocalContext.current;
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()

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
            drawerContent = {DrawerContent() }
        ) {
            CharacterList(getListData(homeViewModel))
        }
    }

    @Composable
    private fun DrawerContent(){
        val bodyModifier: Modifier = Modifier
            .zIndex(8f)
            .fillMaxSize()

        NavigationDrawer().DrawerHeader()
        NavigationDrawer().DrawerBody(
            items = getDrawerMenuItems(),
            bodyModifier,
            onItemClick = { drawerItemOnClick(it) }
        )
    }

    @Composable
    private fun getListData(homeViewModel: HomeViewModel): List<Character> {
        homeViewModel.getCharacters(1)
        val characters by homeViewModel.characterFlow.collectAsState()
        return characters.toList()
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
                id = TabbarItems.HELP,
                title = "Help",
                contentDescription = "Get help",
                icon = Icons.Default.Info
            ),
        )
    }

    private fun drawerItemOnClick(it: MenuItem) {
        if (it.id == TabbarItems.SETTINGS) {
            navController.navigate(Screen.SettingsScreen.route)
        }
    }
}







