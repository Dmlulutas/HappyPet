package com.example.happypet.ui.page

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.happypet.model.Character
import com.example.happypet.ui.component.DrawerMenu
import com.example.happypet.util.Screen
import com.example.happypet.viewModel.HomeViewModel

class HomeScreen(
    override var backstack: String?,
    override var navController: NavHostController,
) : BaseScreen() {
    lateinit var homeViewModel: HomeViewModel
    lateinit var owner: LifecycleOwner


    @Composable
    override fun GetUI(viewModel: ViewModel, _owner: LifecycleOwner) {
        homeViewModel = viewModel as HomeViewModel
        owner = _owner

        Toast.makeText(LocalContext.current, "email $backstack", Toast.LENGTH_LONG).show()
        DrawerMenu(
            onMenuItemClick = {
                navController.navigate(Screen.SettingsScreen.route)
            }
        )


        GetList()
    }


    @Composable
    fun GetList() {

        val characters = remember {  mutableStateListOf<Character>()}
        homeViewModel.characterFlow.let {
            val res= it

        }



       /* homeViewModel.characters.observe(owner) { result ->
            val res: List<Character> = result
            Log.d("Characters size:", characters.size.toString())


        }*/
        ListCharacter(characters)

    }


    @Composable
    fun ListCharacter(characters: List<Character>) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = characters,
                itemContent = {
                    CharacterListItem(character = it)
                })
        }

    }

    @Composable
    fun CharacterListItem(character: Character) {


        Row {
            Column {
                Text(text = character.name, style = typography.h6)
                Text(text = "DETAIL", style = typography.caption)
            }
        }
    }

}



