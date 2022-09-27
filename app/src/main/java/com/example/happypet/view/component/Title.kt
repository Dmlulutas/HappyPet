package com.example.happypet.view.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happypet.R
import com.example.happypet.view.theme.whitesmoke

@Composable
fun Title(text:String){
    Text(
        text = text,
        style = TextStyle(fontSize = 30.sp,color= whitesmoke, fontWeight = FontWeight.ExtraBold))
    Spacer(modifier = Modifier.height(40.dp))
}