package com.example.my_eco.ui.screen.user

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_eco.data.model.User
import com.example.my_eco.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _userState = mutableStateOf<User?>(null)
    val userState: State<User?> get() = _userState

    private val _errorState = mutableStateOf<String?>(null)
    val errorState: State<String?> get() = _errorState

    fun fetchCurrentUser() {
        _userState.value = repository.getCurrentUser()
    }

    fun registerAndAddUser(email: String, password: String, name: String) {
        viewModelScope.launch {
            try {
                // Register the user
                val authResult = repository.registerUser(email, password).await()
                val userId = authResult.user?.uid ?: throw Exception("User registration failed")

                // Add user details to Firestore
                val user = User(id = userId, name = name, email = email)
                repository.addUser(user)

                // Update UI state
                _userState.value = user
                _errorState.value = null
            } catch (e: Exception) {
                _errorState.value = e.message
            }
        }
    }

    fun logout() {
        repository.signOut()
        _userState.value = null
    }
}
