package com.example.kind1.viewlmodel

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await

class SignUpViewModel {
    private lateinit var auth: FirebaseAuth

    fun signUp(email: String, password: String) {
        auth = Firebase.auth

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("Opret status", "success")

                } else {
                    Log.d("Opret status", "fail")
                }
            }
    }

    private val db = Firebase.firestore
    fun addToDatabase(user: String, email: String) {

        val newUser = hashMapOf(
            "username" to user,
            "email" to email,
            "admin" to false
        )
        db.collection("users").document(user).set(newUser)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("DATABASE status", "success")
                } else {
                    Log.d("DATABASE status", "fail")
                }
            }
    }

    suspend fun checkForEmail(email: String): Boolean {
        db.collection("users").whereEqualTo("email", email).get().await() ?: return true
        return false
    }

    fun validInputSign(user: String, pass: String, email: String): Boolean {
        var validate = true

        if (user == "" || pass.length < 6 || !android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches()
        ) {
            validate = false
        }

        return validate
    }


}