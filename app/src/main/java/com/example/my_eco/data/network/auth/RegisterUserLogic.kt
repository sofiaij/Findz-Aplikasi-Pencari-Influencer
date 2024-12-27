package com.eclipse.findz.logic

import android.util.Log
import com.example.my_eco.data.model.User
import com.example.my_eco.data.network.FirebaseService.firestore

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await


fun registerUserLogic(
    name: String,
    email: String,
    password: String,
    confirmPassword: String,
    role: String,
    phoneNumber: String,
    businessField: String?,
    interestField: String?,
    instagramAccount: String?,
    onRegisterSuccess: () -> Unit
) {
    // Validasi data input
    if (name.isBlank() || email.isBlank() || phoneNumber.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
        println("Harap isi semua field yang wajib!")
        return
    }

    if (password != confirmPassword) {
        println("Kata sandi dan konfirmasi kata sandi tidak cocok!")
        return
    }

    if (role == "UMKM" && businessField.isNullOrBlank()) {
        println("Bidang usaha harus diisi untuk UMKM!")
        return
    }

    if (role == "Influencer" && (interestField.isNullOrBlank() || instagramAccount.isNullOrBlank())) {
        println("Bidang minat dan akun Instagram harus diisi untuk Influencer!")
        return
    }

    val auth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()

    // Registrasi dengan Firebase
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val userId = auth.currentUser?.uid ?: ""
                val user = User(
                    id = userId,
                    name = name,
                    email = email,
                    role = role,
                    phoneNumber = phoneNumber,
                    businessField = if (role == "UMKM") businessField else null,
                    interestField = if (role == "Influencer") interestField else null,
                    instagramAccount = if (role == "Influencer") instagramAccount else null
                )

                // Menyimpan data pengguna di Firestore
                db.collection("users").document(userId).set(user)
                    .addOnSuccessListener {
                        println("Registrasi berhasil!")
                        onRegisterSuccess()
                    }
                    .addOnFailureListener { exception ->
                        Log.e("Register", "Gagal menyimpan data pengguna: ${exception.message}")
                    }
            } else {
                Log.e("Register", "Registrasi gagal: ${task.exception?.message}")
                val errorMsg = when (task.exception) {
                    is FirebaseAuthInvalidCredentialsException -> "Email tidak valid."
                    is FirebaseAuthUserCollisionException -> "Email sudah terdaftar."
                    else -> "Registrasi gagal. Silakan coba lagi."
                }
                println(errorMsg)
            }


        }
}

