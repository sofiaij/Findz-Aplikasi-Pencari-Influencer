package com.example.my_eco.ui.screen.home

import androidx.lifecycle.ViewModel
import com.example.my_eco.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    fun logout() {
        repository.signOut()
    }
}
