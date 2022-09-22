package com.example.happypet.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.happypet.model.CharResponse
import com.example.happypet.model.Character
import com.example.happypet.repository.RetrofitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val retrofitRepository: RetrofitRepository) :
    ViewModel() {


    private val _characters = MutableLiveData<List<Character>>()


    val characters: LiveData<List<Character>>
        get() = _characters


    var list = emptyList<Character>()
    private val _characterFlow by lazy { MutableStateFlow(list) }
    val characterFlow = _characterFlow.asStateFlow()



    fun getCharacters(page: Int) {
        viewModelScope.launch {
            retrofitRepository.getCharacters(page).let {
                val charResponse: CharResponse = it.body()!!
                val characters: List<Character> = charResponse.results
                _characters.postValue(characters)
                _characterFlow.value = characters

            }
        }
    }
}


