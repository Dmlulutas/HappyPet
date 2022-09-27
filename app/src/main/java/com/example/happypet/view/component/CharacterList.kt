package com.example.happypet.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.happypet.model.Character
import com.example.happypet.view.theme.contentColor

@Composable
fun CharacterList(characters: List<Character>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        modifier = Modifier
            .zIndex(10f)
            .background(contentColor)
    ) {
        items(
            items = characters,
            itemContent = {
                CharacterCard(character = it)
            })
    }

}