package com.example.happypet.view.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import com.example.happypet.model.Character
import com.example.happypet.model.MenuItem
import com.example.happypet.util.Screen
import com.example.happypet.view.component.AppBar
import com.example.happypet.view.component.DrawerMenu
import com.example.happypet.view.component.NavigationDrawer
import com.example.happypet.view.component.TabbarItems
import com.example.happypet.view.theme.darkBlue
import com.example.happypet.view.theme.darkBlue200
import com.example.happypet.view.theme.springGreen
import com.example.happypet.view.theme.whitesmoke
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
        val bodyModifier: Modifier = Modifier
            .zIndex(8f)
            .background(darkBlue)
            .fillMaxSize()

        Scaffold(
            Modifier
                .fillMaxSize()
                .zIndex(10f)
                .background(Color.Gray),
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
                            navController.navigate(Screen.SettingsScreen.route)
                        }

                    }
                )
            }
        ){
            GetList()
        }


    }


    @Composable
    fun GetList() {

        homeViewModel.getCharacters(1)
        val characters by homeViewModel.characterFlow.collectAsState()

        val listChar = characters.toList()
        ListCharacter(characters = listChar)

    }


    @Composable
    fun ListCharacter(characters: List<Character>) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            modifier = Modifier
                .zIndex(10f)
                .background(Color.Gray)
        ) {
            items(
                items = characters,
                itemContent = {
                    CharacterCard(character = it)
                })
        }

    }

    @Composable
    fun CharacterCard(character: Character) {
        Card(
            modifier = Modifier
                .height(90.dp)
                .padding(vertical = 3.dp)
                .fillMaxWidth()
                .background(Color.Gray),
            elevation = 8.dp,
            shape = RoundedCornerShape(20.dp)) {
            Row(
                modifier = Modifier.background(Color.DarkGray)
            ) {
                CharacterImage(character)
                Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                    Text(text = character.name, style = typography.h6, color = springGreen)
                    Text(text = "DETAIL", style = typography.caption, color = whitesmoke)
                }
            }
        }
    }

    @Composable
    private fun CharacterImage(character: Character) {
        SubcomposeAsyncImage(
            model = character.image,
            modifier = Modifier.fillMaxHeight(),
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = character.name
        )
    }

}





