package com.example.aprenderpalabras.registro

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun RegistroScreen(navController: NavController, viewModel: RegistroViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsState()

    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Center) {
        Text("Nuevo Usuario", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(value = state.name, onValueChange = { viewModel.onNameChange(it) }, label = { Text("Nombre") })
        OutlinedTextField(value = state.email, onValueChange = { viewModel.onEmailChange(it) }, label = { Text("Email") })
        OutlinedTextField(value = state.pass, onValueChange = { viewModel.onPassChange(it) }, label = { Text("Password") })
        Button(onClick = { navController.popBackStack() }) { Text("Registrar") }
    }
}