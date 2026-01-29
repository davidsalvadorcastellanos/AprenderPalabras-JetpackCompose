package com.example.aprenderpalabras.vocabulario

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun VocabularyScreen(viewModel: VocabularyViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsState()
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "\uD83D\uDCD6 Palabra Del Día",
            style = MaterialTheme.typography.displaySmall.copy(
                fontWeight = FontWeight.Black,
                fontSize = 40.sp
            ),
            textAlign = TextAlign.Center
        )
        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(state.palabra, style = MaterialTheme.typography.displaySmall)
                Spacer(Modifier.height(8.dp))
                Text(state.definicion, textAlign = TextAlign.Center)
            }
        }
        Button(onClick = {
            isExpanded = false
            viewModel.nuevaPalabra()
        }) {
            Text("Siguiente Palabra")
        }
    }
}