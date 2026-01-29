package com.example.aprenderpalabras.vocabulario

data class VocabularioUiState(
    val palabra: String = "",
    val definicion: String = "",
    val dia: String = "Palabra del dia"
)