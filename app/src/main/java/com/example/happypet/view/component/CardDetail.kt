package com.example.happypet.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.happypet.model.Character
import com.example.happypet.view.theme.gold
import com.example.happypet.view.theme.whitesmoke

val style = ComponentsStyle()

@Composable
fun CardDetail(character: MutableState<Character?>, openDialog: MutableState<Boolean>) {


    Dialog(
        onDismissRequest = {
            openDialog.value = false
        },
    ) {

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = style.column,

        ) {
            Card(
                modifier = style.card,
                elevation = 8.dp,
            ) {
                Column(
                    modifier = Modifier.background(Color.Black),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    CardImage(character = character)
                    CardTexts(character = character)
                    CancelBtn(openDialog = openDialog)

                }
            }
        }
    }


}

@Composable
fun CardImage(character: MutableState<Character?>) {
    val name: String = character.value!!.name
    val image: String = character.value!!.image
    Column(
        modifier = style.imageLayout,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CharacterImage(name, image)
    }
}

@Composable
fun CardTexts(character: MutableState<Character?>) {

    val name: String = character.value!!.name
    val id: String = character.value!!.id.toString()
    val gender: String = character.value!!.gender.toString()
    val species: String = ""

    Column() {
        PairText(
            key = "Name",
            value = name,
            paddingTop = 20)

        PairText(
            key = "Id",
            value = id,
            paddingTop = 3)

        PairText(
            key = "Gender",
            value = gender,
            paddingTop = 3)

        PairText(
            key = "Species",
            value = species,
            paddingTop = 3)
    }
}

@Composable
fun PairText(key: String, value: String, paddingTop: Int) {
    Row(modifier = Modifier
        .padding(0.dp, paddingTop.dp, 0.dp, 0.dp)) {
        Text("$key: ", style = style.textKey)
        Text(value, style = style.textValue)
    }
}

@Composable
fun CancelBtn(openDialog: MutableState<Boolean>) {
    Row(
        modifier = style.btnContainer,
    ) {

        Button(
            modifier = style.button,
            onClick = {
                openDialog.value = false
            }) {
            Text("CANCEL", style = style.btnText)
        }

    }
}

class ComponentsStyle() {
    val column: Modifier = Modifier
        .background(Color.Black, RoundedCornerShape(30.dp))
        .clip(RoundedCornerShape(30.dp))

    val card: Modifier = Modifier
        .height(400.dp)
        .background(Color.Black)
        .clip(RoundedCornerShape(20.dp))

    val textKey = TextStyle(
        color = gold.copy(.5f),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )

    val textValue = TextStyle(
        color = whitesmoke.copy(.5f),
        fontSize = 20.sp
    )

    val btnContainer: Modifier = Modifier.fillMaxWidth()

    val button: Modifier = Modifier
        .padding(2.dp, 20.dp, 0.dp, 20.dp)
        .fillMaxSize()
        .height(30.dp)

    val btnText = TextStyle(
        fontSize = 20.sp,
        color = gold.copy(.5f),
    )
    val imageLayout: Modifier = Modifier
        .height(180.dp)
        .padding(0.dp, 20.dp, 0.dp, 0.dp)
        .clip(RoundedCornerShape(130.dp, 130.dp, 130.dp, 130.dp))

}