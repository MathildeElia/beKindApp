package com.example.kind1.viewlmodel

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.kind1.Screen
import com.example.kind1.data.Organisation
import com.example.kind1.data.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import org.checkerframework.checker.units.qual.s
import kotlin.system.exitProcess

class LoginViewModel : ViewModel() {
    data class UserUiState(
        var userList: User = User()
    )

    val userState = MutableStateFlow(User())

    private lateinit var auth: FirebaseAuth

    fun validLogin(email: String, password: String): Boolean {
        var validate = true

        if (password.length < 6 || !android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches()
        ) {
            validate = false
        }

        return validate
    }

    fun login(email: String, password: String, navController: NavController): String {
        var validate = 0
        if (!validLogin(email, password)) {
            return "Enten email eller password er forkert"
        }

        val db = FirebaseFirestore.getInstance()
        db.collection("users")
            .whereEqualTo("email", email)
            .get()
            .addOnSuccessListener { documents ->
                val users = documents.map { document ->

                    val user = User()
                    user.email = document.get("email") as String
                    user.username = document.get("username") as String
                    user.admin = document.get("admin") as Boolean
                    Log.w(ContentValues.TAG, "LOGIN FAILED")
                    user

                }

                userState.value = users.get(0)

            }
            .addOnFailureListener {
                validate = 1
            }


        if (validate == 0) {
            auth = Firebase.auth
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("Log in status", "success")
                        if (userState.value.admin) {
                            navController.navigate(Screen.AdminPage.withArgs(userState.value.username))
                        } else if (!userState.value.admin) {
                            navController.navigate(Screen.KindStart.withArgs(userState.value.username))
                        }

                    } else {
                        Log.w("Log in status", "fail", task.exception)
                    }
                }
            return ""
        } else {
            return "Enten email eller password er forkert"
        }
    }


}


