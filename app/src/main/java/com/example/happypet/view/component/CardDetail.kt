package com.example.happypet.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.happypet.model.Character
import com.example.happypet.view.theme.whitesmoke

@Composable
fun CardDetail(character: MutableState<Character?>, openDialog: MutableState<Boolean>) {
    val style = ComponentsStyle()
    val charName: String = character.value!!.name
    val charImage: String = character.value!!.image
    Dialog(
        onDismissRequest = {
            openDialog.value = false
        },
    ) {

        Surface(
            color= Color.Black,
            shape = RoundedCornerShape(16.dp)
        ) {
            Card(
                modifier = style.card,
                elevation = 8.dp,
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(
                    modifier = Modifier.background(Color.Black)
                ) {
                    Column(modifier = style.imageLayout) {
                        CharacterImage(charName, charImage)
                    }
                    Text("Id: " + character.value?.id.toString(), color = whitesmoke, modifier = Modifier.padding(0.dp,20.dp,0.dp,0.dp))
                    Text("Gender: " + character.value?.gender.toString(), color = whitesmoke)
                    Text("Species: " + character.value?.species.toString(), color = whitesmoke)

                    Row(modifier = style.btnContainer) {

                        Button(
                            modifier = style.button,
                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("Cancel", color = whitesmoke)
                        }

                    }
                }
            }
        }
    }

}

class ComponentsStyle() {
    val btnContainer: Modifier = Modifier.fillMaxWidth()
    val button: Modifier = Modifier
        .padding(2.dp,20.dp,0.dp,0.dp)
        .width(140.dp)
        .height(40.dp)

    val card: Modifier = Modifier
        .height(350.dp)
        .background(Color.Black)
        .padding(20.dp,0.dp,0.dp,0.dp)

    val imageLayout: Modifier = Modifier
        .height(180.dp)
        .width(180.dp)
        .clip(RoundedCornerShape(30.dp,30.dp,30.dp,30.dp))

}