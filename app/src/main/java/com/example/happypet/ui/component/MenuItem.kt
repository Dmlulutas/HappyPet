package com.example.happypet.ui.component

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id : TabbarItems,
    val title:String,
    val contentDescription:String?,
    val icon :ImageVector){

}
