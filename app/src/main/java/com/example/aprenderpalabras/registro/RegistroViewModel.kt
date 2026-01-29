package com.example.aprenderpalabras.registro

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegistroViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegistroUiState())
    val uiState = _uiState.asStateFlow()

    fun onNameChange(v: String) = _uiState.update { it.copy(name = v) }
    fun onEmailChange(v: String) = _uiState.update { it.copy(email = v) }
    fun onPassChange(v: String) = _uiState.update { it.copy(pass = v) }
}