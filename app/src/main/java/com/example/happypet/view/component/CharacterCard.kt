package com.example.happypet.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.happypet.model.Character
import com.example.happypet.view.theme.gold
import com.example.happypet.view.theme.whitesmoke


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CharacterCard(character: Character, onClickCard: (it:Character) -> Unit) {
    Card(
        onClick = { onClickCard(character) },
        modifier = Modifier
            .height(80.dp)
            .padding(vertical = 4.dp)
            .border(.5.dp, gold,RoundedCornerShape(25.dp))
            .fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(20.dp)) {
        Row(
            modifier = Modifier
                .background(Color.Black)
        ) {
            CharacterImage(character.name,character.image)
            Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
                Text(text = character.name,
                    style = MaterialTheme.typography.subtitle1,
                    color = whitesmoke)
                Text(text = "DETAIL", style = MaterialTheme.typography.caption, color = whitesmoke)
            }
        }
    }
}