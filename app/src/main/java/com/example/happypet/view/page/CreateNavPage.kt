package com.example.happypet.view.page

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.example.happypet.R
import com.example.happypet.factory.Alert
import com.example.happypet.model.AlertType
import com.example.happypet.view.theme.*

val style = PageStyle()

class CreateNavPage(
    override var backstack: String?,
) : BaseScreen() {


    @Composable
    override fun GetUI(viewModel: ViewModel, owner: LifecycleOwner) {
        val context = LocalContext.current
        val pairList = listOf<Pair<String, String>>(

            Pair("Key1", "Entry1"),
            Pair("Key2", "Entry2"),
            Pair("Key3", "Entry3")
        )


        val ownerState = remember { mutableStateOf("") }
        val addressState = remember { mutableStateOf("") }
        val noteState = remember { mutableStateOf("") }
        val btnEnabled = !ownerState.value.isEmpty() &&
                !addressState.value.isEmpty() &&
                !noteState.value.isEmpty()

        Scaffold(backgroundColor = black400) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = style.column
            ) {
                Text(text = context.getString(R.string.name))
                InputText(title = context.getString(R.string.name), valueState = ownerState)
                InputText(title = context.getString(R.string.address), valueState = addressState)
                InputText(title = context.getString(R.string.note), valueState = noteState)

                if (backstack == AlertType.Red.toString()) {
                    AlertRedLayout()
                } else {
                    AlertGreenLayout()
                }
                SampleSpinner(pairList, pairList[0], onSelectionChanged = {
                    Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()
                })
                CreateBtn(btnEnabled)
            }
        }


    }

    @Composable
    fun CreateBtn(enabled: Boolean) {
        val context = LocalContext.current
        Box(modifier = style.btnBox) {
            Button(
                shape = RoundedCornerShape(50.dp),
                enabled = enabled,
                modifier = style.createBtn,
                onClick = { Log.d("f", "f") }
            ) {
                Text(
                    text = context.getString(R.string.create_alert),
                    style = style.btnText
                )
            }
        }

    }

    @Composable
    fun AlertRedLayout() {
        val context = LocalContext.current

        val urgencyState = remember { mutableStateOf("") }
        InputText(title = context.getString(R.string.urgency), valueState = urgencyState)
    }

    @Composable
    fun AlertGreenLayout() {
        val context = LocalContext.current

        val helpTypeState = remember { mutableStateOf("") }

        InputText(title = context.getString(R.string.help_type), valueState = helpTypeState)

    }

    @Composable
    fun InputText(title: String, valueState: MutableState<String>) {
        val isError = remember { mutableStateOf(false) }
        Box(modifier = style.inputBox) {
            TextField(
                textStyle = style.inputText,
                modifier = style.input,
                label = {
                    Text(
                        text = title,
                        style = style.inputTitle
                    )
                },
                value = valueState.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                onValueChange = {
                    valueState.value = it
                    isError.value = valueState.value.isEmpty()
                },
                isError = isError.value
            )
        }
    }


    @Composable
    fun SampleSpinner(
        list: List<Pair<String, String>>,
        preselected: Pair<String, String>,
        onSelectionChanged: (selection: Pair<String, String>) -> Unit,
    ) {
        val context = LocalContext.current
        val selected = remember { mutableStateOf(preselected) }
        val expanded = remember { mutableStateOf(false) } // initial value

        Box(modifier = style.spinnerBox) {
            Column (modifier = style.spinnerTitle){
                OutlinedTextField(
                    value = (selected.value.second),
                    onValueChange = { },
                    label = {
                        Text(
                            text = context.getString(R.string.urgency),
                            style = style.inputTitle
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = { Icon(Icons.Outlined.ArrowDropDown, null) },
                    readOnly = true
                )
                DropdownMenu(
                    modifier = Modifier.width(170.dp),
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false },
                ) {
                    list.forEach { entry ->

                        DropdownMenuItem(
                            modifier = Modifier.width(170.dp).background(black300),
                            onClick = {
                                selected.value = entry
                                expanded.value = false
                            },
                            content = {

                                Text(
                                    style = style.inputText,
                                    text = (entry.second),
                                    modifier = style.spinnerTitle
                                )
                            }

                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.Transparent)
                    .padding(10.dp)
                    .clickable(
                        onClick = { expanded.value = !expanded.value }
                    )
            )
        }
    }

}


class PageStyle() {

    val column: Modifier = Modifier
        .fillMaxSize()
        .padding(70.dp)

    val inputBox: Modifier = Modifier
        .padding(4.dp)
        .border(.2.dp, whitesmoke, RoundedCornerShape(30f))

    val spinnerBox: Modifier = Modifier
        .padding(4.dp)
        .border(.2.dp, whitesmoke, RoundedCornerShape(30f)).
            background(black300)

    val btnBox: Modifier = Modifier
        .padding(4.dp, 20.dp, 4.dp, 4.dp)
        .background(Color.Black)

    val input: Modifier = Modifier
        // .border(.2.dp, whitesmoke, RoundedCornerShape(30f))
        .background(black300)

    val inputTitle = TextStyle(
        color = whitesmoke.copy(.9f),
        fontSize = 17.sp,
    )
    val inputText = TextStyle(
        color = whitesmoke.copy(.7f),
        fontSize = 15.sp
    )

    val createBtn: Modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .clip(Shapes.medium)
        .border(2.dp, Color.Black, RoundedCornerShape((50.dp)))

    val btnText = TextStyle(
        fontSize = 17.sp,
    )

    val spinnerTitle: Modifier = Modifier.padding(7.dp)

}