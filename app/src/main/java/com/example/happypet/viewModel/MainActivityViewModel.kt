package com.example.happypet.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.happypet.model.Character
import com.example.happypet.repository.RetrofitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RetrofitRepository) : ViewModel() {


    private val _subscriptionType = MutableStateFlow<String>("")

    val subscriptionType: StateFlow<String> = _subscriptionType

    fun onSubscriptionTypeChange(type: String) {
        _subscriptionType.value = type
    }

}