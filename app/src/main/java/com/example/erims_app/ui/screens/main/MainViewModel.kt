package com.example.erims_app.ui.screens.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var mainUiState by mutableStateOf(MainUiState())
        private set

    fun showNavigationBar() {
        if (!mainUiState.isNavigationBarVisible) {
            mainUiState = MainUiState(isNavigationBarVisible = true)
        }
    }

    fun hideNavigationBar() {
        if (mainUiState.isNavigationBarVisible) {
            mainUiState = MainUiState(isNavigationBarVisible = false)
        }
    }

}

data class MainUiState(
    val isNavigationBarVisible: Boolean = true
)