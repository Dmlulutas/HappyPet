package com.example.happypet.view.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.SubcomposeAsyncImage
import com.example.happypet.model.Character


@Composable
fun CharacterImage(character: Character) {
    SubcomposeAsyncImage(
        model = character.image,
        modifier = Modifier.fillMaxHeight(),
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = character.name
    )
}
