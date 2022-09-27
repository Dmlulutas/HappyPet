package com.example.happypet.viewModel

import androidx.lifecycle.ViewModel
import com.example.happypet.repository.RetrofitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateNavViewModel @Inject constructor(private val retrofitRepository: RetrofitRepository):
    ViewModel(){
}