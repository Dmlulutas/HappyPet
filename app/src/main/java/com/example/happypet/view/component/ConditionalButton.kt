package com.example.happypet.view.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.happypet.view.theme.Shapes
import com.example.happypet.view.theme.black100

@Composable
fun ConditionalButton( text:String,enableCondition :Boolean, onClick:()->Unit){

    Box(
        modifier = Modifier.padding(50.dp, 0.dp, 50.dp, 0.dp)) {
        Button(
            shape = RoundedCornerShape(50.dp),
            enabled =enableCondition,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(Shapes.medium)
                .border(2.dp, black100, RoundedCornerShape((50.dp))),
            onClick = { onClick() },
        ) {
            Text(text)
        }
    }

    Spacer(modifier = Modifier.height(20.dp))
}