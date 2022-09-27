package com.example.happypet.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.happypet.view.component.TabbarItems

data class MenuItem(
    val id : TabbarItems,
    val title:String,
    val contentDescription:String?,
    val icon :ImageVector){

}
