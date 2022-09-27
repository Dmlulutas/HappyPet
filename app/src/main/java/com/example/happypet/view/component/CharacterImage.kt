package com.example.happypet.view.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage


@Composable
fun CharacterImage(name:String,image: String) {
    SubcomposeAsyncImage(
        model = image,
        modifier = Modifier.fillMaxHeight().clip(RoundedCornerShape(20.dp)),
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = name
    )
}
