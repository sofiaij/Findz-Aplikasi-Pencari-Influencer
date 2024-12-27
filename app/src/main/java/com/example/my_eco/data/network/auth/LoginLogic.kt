package com.example.my_eco.data.network.auth

import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

fun loginUser(
    email: String,
    password: String,
    navController: NavController,
    onError: (String) -> Unit
) {
    if (email.isBlank() || password.isBlank()) {
        onError("Email dan password tidak boleh kosong!")
        return
    }

    val auth = FirebaseAuth.getInstance()
    val firestore = FirebaseFirestore.getInstance()

    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val userId = auth.currentUser?.uid
                if (userId != null) {
                    firestore.collection("users").document(userId).get()
                        .addOnSuccessListener { document ->
                            if (document != null && document.exists()) {
                                val role = document.getString("role")
                                when (role) {
                                    "influencer" -> {
                                        navController.navigate("home") //TODO: ini harusnya ke homenya influencer
                                    }
                                    "UMKM" -> {
                                        navController.navigate("home") // Halaman untuk UMKM
                                    }
                                    else -> {
                                        onError("Role tidak dikenal! Hubungi admin.")
                                    }
                                }
                            } else {
                                onError("Data pengguna tidak ditemukan.")
                            }
                        }
                        .addOnFailureListener { exception ->
                            onError("Gagal mengambil data pengguna: ${exception.message}")
                        }
                } else {
                    onError("Login berhasil, tetapi ID pengguna tidak ditemukan.")
                }
            } else {
                val errorMsg = task.exception?.message ?: "Login gagal. Coba lagi."
                onError(errorMsg)
            }
        }
}


