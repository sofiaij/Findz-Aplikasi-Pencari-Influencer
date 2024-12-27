package com.example.findz

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    // Menyimpan query pencarian dalam bentuk mutableStateOf
    var searchQuery = mutableStateOf("")
}
