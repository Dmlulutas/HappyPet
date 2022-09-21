package com.example.happypet.ui.component

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.happypet.ui.theme.darkBlue
import com.example.happypet.ui.theme.springGreen

@Composable
fun Menu (context: Context) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()

            .clickable {
                true;"Description";null;
            },
        color = darkBlue
    ) {

        topBar(context)

    }
}

@Composable
private fun topBar (context: Context){

    var mDisplayMenu =false
    var fragmentName = "";
    // Creating a Top bar

    val title =context.getString(com.example.happypet.R.string.helping_stray_animals)

    TopAppBar(
        title = { Text( title, color = springGreen) } ,backgroundColor = darkBlue,

        actions = {
            // Creating Icon button favorites, on click
            // would create a Toast message
            IconButton(
                onClick = {
                    mDisplayMenu = true
                    Toast.makeText(context, "Call", Toast.LENGTH_SHORT).show()
                }) {
                Icon(Icons.Default.Call, "Call", tint = Color.Red)
            }

        }

    )
}

