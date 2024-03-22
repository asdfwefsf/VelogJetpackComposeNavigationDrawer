package com.company.velogjetpackcomposenavigationdrawer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var state by mutableStateOf("Home")
        private set

    fun changeState(newState: String) {
        state = newState
    }
}
