package com.example.happypet.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.happypet.model.Character
import com.example.happypet.view.theme.contentColor
import com.example.happypet.view.theme.gray100
import com.example.happypet.view.theme.gray200


@Composable
fun CharacterCard(character: Character) {
    Card(
        modifier = Modifier
            .height(90.dp)
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(20.dp)) {
        Row(modifier = Modifier
            .border(2.dp, Color.Gray)
            .background(contentColor)
        ) {
            CharacterImage(character)
            Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
                Text(text = character.name, style = MaterialTheme.typography.h6, color = gray100)
                Text(text = "DETAIL", style = MaterialTheme.typography.caption, color = gray200)
            }
        }
    }
}