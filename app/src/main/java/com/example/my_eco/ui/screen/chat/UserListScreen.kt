package com.example.my_eco.ui.screen.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.Image
import coil.Coil
import com.example.my_eco.data.model.User

import com.example.my_eco.ui.component.StyledSearchBar
import com.example.my_eco.ui.component.UserAvatar

@Composable
fun UserListScreen(
    onUserClick: (String, String) -> Unit,
    viewModel: ChatViewModel = hiltViewModel(),

) {
    val users by viewModel.users.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    // Memastikan pengguna dimuat ketika komponen pertama kali ditampilkan
    LaunchedEffect(Unit) {
        viewModel.loadUsers()
    }
    
    
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()

                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
           Box(
               modifier = Modifier.size(20.dp)
           ) {

           }
            Text(
                text = "Chat",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(48.dp)) // Spacer for alignment
        }

        StyledSearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            modifier = Modifier.padding(16.dp)
        )

        // Filter pengguna berdasarkan input pencarian
        val filteredUsers = remember(users, searchQuery) {
            users.filter { user ->
                user.name.contains(searchQuery, ignoreCase = true)
            }
        }

        // Daftar Pengguna
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(14.dp)) {
            if (filteredUsers.isEmpty()) {
                item {
                    Text(
                        text = "Tidak ada pengguna ditemukan",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            } else {
                items(filteredUsers) { user ->
                    UserItem(
                        user = user,
                        lastMessage = "Ketuk untuk mengirim pesan",
                        timestamp = null,
                        unreadCount = 0,
                        onClick = { onUserClick(user.id, user.name) }
                    )
                }
            }
        }
    }
}


@Composable
fun UserItem(
    user: User,
    lastMessage: String,
    timestamp: Long?,
    unreadCount: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(14.dp)
    ) {
        // Avatar Placeholder
        Box(
            modifier = Modifier
                .size(48.dp)

        )
        {
            UserAvatar("https://avatar.iran.liara.run/public")
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = user.name,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = lastMessage,
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)),
                maxLines = 1
            )
        }

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            timestamp?.let {
                Text(
                    text = formatTimestamp(it),
                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                )
            }
            if (unreadCount > 0) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(MaterialTheme.colorScheme.primary, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = unreadCount.toString(),
                        style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onPrimary)
                    )
                }
            }
        }
    }
}


