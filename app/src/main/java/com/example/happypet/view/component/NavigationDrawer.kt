package com.example.happypet.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happypet.model.MenuItem
import com.example.happypet.view.theme.*

class NavigationDrawer {

    @Composable
    fun DrawerHeader(text:String) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(contentColor)
                .padding(vertical = 30.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = TextStyle(
                    color = whitesmoke,
                    textAlign = TextAlign.Left,
                    fontSize = 24.sp
                )
            )
        }
    }

    @Composable
    fun DrawerBody(
        items: List<MenuItem>,
        modifier: Modifier = Modifier,
        itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
        onItemClick: (MenuItem) -> Unit,
    ) {

        LazyColumn(modifier.background(Color.Black)) {
            items(items) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onItemClick(item)
                        }
                        .padding(12.dp)
                ) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.contentDescription,
                        tint = gray100
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = item.title,
                        style = itemTextStyle,
                        color = whitesmoke.copy(.7f),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}