package com.example.aprenderpalabras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aprenderpalabras.ajustes.SettingsScreen
import com.example.aprenderpalabras.ajustes.SettingsViewModel
import com.example.aprenderpalabras.login.LoginScreen
import com.example.aprenderpalabras.registro.RegistroScreen
import com.example.aprenderpalabras.vocabulario.VocabularyScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val settingsVM: SettingsViewModel = viewModel()
            val settingsState by settingsVM.uiState.collectAsState()

            MaterialTheme(
                colorScheme = if (settingsState.isDarkMode) darkColorScheme() else lightColorScheme()
            ) {
                MainApp(settingsVM)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(settingsVM: SettingsViewModel) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerItem(
                    label = { Text("Vocabulario") },
                    selected = false,
                    onClick = { navController.navigate("vocabulary"); scope.launch { drawerState.close() } })
                NavigationDrawerItem(
                    label = { Text("Ajustes") },
                    selected = false,
                    onClick = { navController.navigate("settings"); scope.launch { drawerState.close() } })
            }
        }
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Palabra diaria") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = null)
                        }
                    }
                )
            }
        ) { padding ->
            NavHost(navController, startDestination = "login", Modifier.padding(padding)) {
                composable("login") { LoginScreen(navController) }
                composable("register") { RegistroScreen(navController) }
                composable("vocabulary") { VocabularyScreen() }
                composable("settings") { SettingsScreen(settingsVM) }
            }
        }
    }
}