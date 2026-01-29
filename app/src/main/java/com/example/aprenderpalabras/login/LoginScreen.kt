package com.example.aprenderpalabras.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Bienvenido", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(value = state.user, onValueChange = { viewModel.onUserChange(it) }, label = { Text("Usuario") })
        OutlinedTextField(value = state.pass, onValueChange = { viewModel.onPassChange(it) }, label = { Text("Password") })
        Spacer(Modifier.height(16.dp))
        Button(onClick = { navController.navigate("vocabulary") }) { Text("Entrar") }
        TextButton(onClick = { navController.navigate("register") }) { Text("Crear cuenta") }
    }
}