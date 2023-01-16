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

class LoginViewModel: ViewModel(){
    data class UserUiState(
        var userList: User = User()
    )
    val userState = MutableStateFlow(User())

    private lateinit var auth: FirebaseAuth

    fun login(email: String, password: String,navController: NavController): String {
        val db = FirebaseFirestore.getInstance()
        db.collection("users")
            .whereEqualTo("email", email)
            .get()
            .addOnSuccessListener{ documents ->
                    val users = documents.map{ document ->

                        val user = User()
                        user.email = document.get("email") as String
                        user.username = document.get("username") as String
                        user.password = document.get("password") as String
                        Log.w(ContentValues.TAG, "Organisations $user")
                        user
                    }
                userState.value = users.get(0)

            }



        auth = Firebase.auth
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Log.d("Log in status","success")
                    navController.navigate(Screen.KindStart.withArgs(userState.value.username))
                }else {
                    Log.d("Log in status","fail")
                }
            }
        return "Enten email eller password er forkert"

    }


}


