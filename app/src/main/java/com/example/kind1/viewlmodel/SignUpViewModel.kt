package com.example.kind1.viewlmodel

import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpViewModel {
    private lateinit var auth: FirebaseAuth

    fun signUp(email: String, password: String){
        auth = Firebase.auth

        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{task ->
                if (task.isSuccessful){
                    Log.d("Opret status","success")

                }else {
                    Log.d("Opret status","fail")
                }



            }
    }




}