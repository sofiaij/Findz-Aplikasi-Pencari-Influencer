package com.example.my_eco.ui.screen.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_eco.data.repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(
    internal val repository: UserRepository
) : ViewModel() {

    private val _isUserLoggedIn = MutableStateFlow(false)
    val isUserLoggedIn: StateFlow<Boolean> = _isUserLoggedIn

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _loginError = MutableStateFlow<String?>(null)
    val loginError: StateFlow<String?> = _loginError

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                repository.loginUser(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        _isUserLoggedIn.value = true
                        _loginError.value = null
                    } else {
                        _isUserLoggedIn.value = false
                        _loginError.value = task.exception?.message ?: "Unknown error"
                    }
                    _isLoading.value = false
                }
            } catch (e: Exception) {
                _isLoading.value = false
                _loginError.value = e.message
            }
        }
    }

    fun setLoginError(message: String) {
        _loginError.value = message
    }
}
