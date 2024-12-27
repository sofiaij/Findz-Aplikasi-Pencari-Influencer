package com.example.my_eco.ui.screen.user

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UserScreen(viewModel: UserViewModel = hiltViewModel(), onLogout: () -> Boolean) {
    val user by viewModel.userState
    val error by viewModel.errorState

    LaunchedEffect(Unit) {
        viewModel.fetchCurrentUser()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        user?.let {
            Text(text = "Welcome, ${it.name}")
        } ?: Text(text = "No user logged in")

        error?.let {
            Text(text = "Error: $it", color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.registerAndAddUser(
                    email = "cht@test.com",
                    password = "123456",
                    name = "chat Ea"
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Register and Add User")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.logout()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Logout")
        }
    }
}
