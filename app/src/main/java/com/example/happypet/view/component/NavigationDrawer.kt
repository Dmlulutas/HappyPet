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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happypet.view.theme.darkGreen
import com.example.happypet.view.theme.springGreen

class NavigationDrawer {

    @Composable
    fun DrawerHeader() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(darkGreen)
                .padding(vertical = 30.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Account", style = TextStyle(color = springGreen, textAlign = TextAlign.Left, fontSize = 34.sp))
        }
    }

    @Composable
    fun DrawerBody(
        items: List<MenuItem>,
        modifier: Modifier = Modifier,
        itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp, color = springGreen),
        onItemClick: (MenuItem) -> Unit
    ) {

        LazyColumn(modifier) {
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
                        tint = springGreen
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = item.title,
                        style = itemTextStyle,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}