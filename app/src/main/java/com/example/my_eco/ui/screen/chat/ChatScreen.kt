package com.example.my_eco.ui.screen.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.my_eco.data.model.Message
import com.example.my_eco.ui.component.PageHeader

@Composable
fun ChatScreen(
    navController: NavController,
    chatId: String,
    userId: String,
    nameDesti: String,
    viewModel: ChatViewModel = hiltViewModel()
) {
    val messages by viewModel.messages.collectAsState()
    var text by remember { mutableStateOf("") }

    // Load messages when chatId is initialized
    LaunchedEffect(chatId) {
        viewModel.listenForMessages(chatId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()

    ) {
        // Header
        PageHeader(title = nameDesti, onBackClick = {navController.popBackStack()})

        // Message List
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
            ,

//            reverseLayout = true
        ) {
            if (messages.isEmpty()) {
                item {
                    Text(
                        text = "Belum ada pesan",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            } else {
                items(messages) { message ->
                    ChatBubble(
                        message = message,
                        isCurrentUser = message.senderId == userId
                    )
                }
            }
        }

        // Input Field
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(

                value = text,
                onValueChange = { text = it },
                placeholder = { Text("Tulis pesan") },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(24.dp)
            )
            IconButton(onClick = {
                if (text.isNotBlank()) {
                    viewModel.sendMessage(chatId, userId, text)
                    text = ""
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send" ,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun ChatBubble(message: Message, isCurrentUser: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = if (isCurrentUser) Arrangement.End else Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = if (isCurrentUser) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(12.dp)
                .widthIn(max = 250.dp) // Limit bubble width
        ) {
            Column {
                Text(
                    text = message.text,
                    color = if (isCurrentUser) MaterialTheme.colorScheme.onPrimary else Color(0xFF000000),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = formatTimestamp(message.timestamp),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

fun formatTimestamp(timestamp: Long): String {
    val sdf = java.text.SimpleDateFormat("hh:mm a", java.util.Locale.getDefault())
    return sdf.format(java.util.Date(timestamp))
}
