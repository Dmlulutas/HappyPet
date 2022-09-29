package com.example.happypet.view.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.happypet.model.Character
import com.example.happypet.model.MenuItem
import com.example.happypet.model.enums.Screen
import com.example.happypet.model.enums.TabbarItems
import com.example.happypet.util.MainNavigation
import com.example.happypet.view.MainActivity
import com.example.happypet.view.component.AppBar
import com.example.happypet.view.component.CardDetail
import com.example.happypet.view.component.CharacterCard
import com.example.happypet.view.component.NavigationDrawer
import com.example.happypet.view.theme.HomePageTheme
import com.example.happypet.viewModel.HomeViewModel
import kotlinx.coroutines.launch

class HomeScreen(
    override var backstack: String?,
) : BaseScreen() {

    lateinit var homeViewModel: HomeViewModel
    lateinit var owner: LifecycleOwner
    lateinit var openCardDetail: MutableState<Boolean>
    lateinit var selectedCharacter: MutableState<Character?>


    @Composable
    override fun GetUI(viewModel: ViewModel, owner: LifecycleOwner) {
        // Toast.makeText(LocalContext.current, "email $backstack", Toast.LENGTH_LONG).show()

        homeViewModel = viewModel as HomeViewModel
        this.owner = owner as MainActivity

        openCardDetail = remember { mutableStateOf(false) }
        selectedCharacter = remember { mutableStateOf(null) }

        Scaffold() {
            CharacterList()
        }

    }

    @Composable
    private fun CharacterList() {
        homeViewModel.getCharacters(1)
        val characters by homeViewModel.characterFlow.collectAsState()

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            modifier = Modifier
                .zIndex(10f)
                .background(Color.Black)
        ) {
            items(
                items = characters,
                itemContent = {
                    CharacterCard(character = it, onClickCard = { selectCharacter(it) })
                })
        }
    }

    private fun selectCharacter(selectChar: Character) {
        openCardDetail.value = true
        selectedCharacter.value = selectChar
    }


}







