package com.example.happypet.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.happypet.model.CharResponse
import com.example.happypet.model.Character
import com.example.happypet.ui.theme.HomePageTheme
import com.example.happypet.util.Navigation
import com.example.happypet.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private var coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    private var handler = CoroutineExceptionHandler{
        coroutineContext, throwable -> Log.d("MainActivity",throwable.toString())
    }


    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeViewModel = ViewModelProvider(this@MainActivity)[HomeViewModel::class.java]

        setContent {
            HomePageTheme {
                Surface {
                    Navigation(this)
                    //GetRetrofitData()
                }
            }
        }
    }


    @Composable
    fun GetRetrofitData() {

        Button(
            onClick = {
                homeViewModel.getCharacters(1)
                homeViewModel.characters.observe(this) { result ->
                 val res :List<Character> =result
                   Log.d("test", res.size.toString())
                }

            }) {
            Text(
                text = "Get Data",
                fontSize = 30.sp,
                color = Color.Green,
            )
        }
    }

    @Composable
    fun GetText() {

        Text(
            text = "test",
            fontSize = 20.sp,
            color = Color.White,
            style = TextStyle(background = Color.Blue)
        )

    }

    /*@Preview(showBackground = true)
      @Composable
      fun DefaultPreview() {
          Navigation(this)
      }
      */


}





