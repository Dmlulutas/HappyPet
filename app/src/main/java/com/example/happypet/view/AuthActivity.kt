package com.example.happypet.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.happypet.util.AuthNavigation
import com.example.happypet.view.theme.HomePageTheme
import com.example.happypet.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : ComponentActivity() {
    lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authViewModel = ViewModelProvider(this@AuthActivity)[AuthViewModel::class.java]

        setContent {
            HomePageTheme {
                Surface {
                    AuthNavigation(owner = this@AuthActivity)
                }
            }
        }
    }


}