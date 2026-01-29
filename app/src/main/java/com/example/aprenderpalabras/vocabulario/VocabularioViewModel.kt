package com.example.aprenderpalabras.vocabulario

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class VocabularyViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(VocabularioUiState())
    val uiState = _uiState.asStateFlow()

    init {
        nuevaPalabra()
    }

    fun nuevaPalabra() {
        val item = VocabularioData.listaEjemplo.random()
        _uiState.update { it.copy(palabra = item.palabra, definicion = item.definicion) }
    }
}
