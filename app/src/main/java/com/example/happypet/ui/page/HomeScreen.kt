package com.example.happypet.ui.page

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.happypet.R
import com.example.happypet.model.Character
import com.example.happypet.ui.component.DrawerMenu
import com.example.happypet.ui.theme.Shapes
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
        Toast.makeText(LocalContext.current, "email $backstack", Toast.LENGTH_LONG).show()

        homeViewModel = viewModel as HomeViewModel
        owner = _owner

        Scaffold() {

            DrawerMenu(
                onMenuItemClick = {
                    navController.navigate(Screen.SettingsScreen.route)
                }
            )

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
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            modifier = Modifier.padding(vertical = 80.dp)
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
                .fillMaxWidth(),
            elevation = 4.dp,
            shape = RoundedCornerShape(20.dp)) {
            Row(
            ) {
                CharacterImage(character)
                Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                    Text(text = character.name, style = typography.h6)
                    Text(text = "DETAIL", style = typography.caption)
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





