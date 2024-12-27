package com.example.my_eco.data.repository

import com.example.my_eco.data.model.User
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) {
    fun loginUser(email: String, password: String): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email, password)
    }

    fun registerUser(email: String, password: String): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password)
    }

    suspend fun addUser(user: User) {
        val userMap = mapOf(
            "id" to user.id,
            "name" to user.name,
            "email" to user.email
        )
        firestore.collection("users").document(user.id).set(userMap).await()
    }

    fun signOut() {
        auth.signOut()
    }

    fun getCurrentUser(): User? {
        val firebaseUser = auth.currentUser
        return firebaseUser?.let {
            User(
                id = it.uid,
                name = it.displayName ?: "Unknown", // Default value jika displayName kosong
                email = it.email ?: "No Email" // Default value jika email kosong
            )
        }
    }

    suspend fun getAllUsers(): List<User> {
        val snapshot = firestore.collection("users").get().await()
        return snapshot.toObjects(User::class.java)
    }
}
