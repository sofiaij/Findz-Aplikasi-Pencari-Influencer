package com.example.my_eco.ui.screen.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_eco.data.model.Message
import com.example.my_eco.data.model.RecentMessage
import com.example.my_eco.data.model.User
import com.example.my_eco.data.repository.MessageRepository
import com.example.my_eco.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: MessageRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users


    fun listenForMessages(chatId: String) {
        repository.getMessages(chatId) { messages ->
            _messages.value = messages
        }
    }

    fun sendMessage(chatId: String, senderId: String, text: String) {
        viewModelScope.launch {
            val message = Message(senderId = senderId, text = text, timestamp = System.currentTimeMillis())
            repository.sendMessage(chatId, message)
        }
    }

    private val _recentMessages = MutableStateFlow<Map<String, RecentMessage>>(emptyMap())
    val recentMessages: StateFlow<Map<String, RecentMessage>> = _recentMessages

    fun loadRecentMessages() {
        viewModelScope.launch {
            val recentMessagesMap = repository.getRecentMessages()
            _recentMessages.value = recentMessagesMap
        }
    }


    fun loadUsers() {
        viewModelScope.launch {
            _users.value = userRepository.getAllUsers()
        }
    }
}
