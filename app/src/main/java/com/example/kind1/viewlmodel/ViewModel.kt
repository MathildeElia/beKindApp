package com.example.kind1

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kind1.data.Organisation
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.reflect.Modifier

data class organisationUiState(
    var organisation: Organisation = Organisation()
)
class Viewmodel : ViewModel() {

    init {

    }

    var username = mutableStateOf("")
    var working = mutableStateOf("")

    var organisationState = MutableStateFlow(organisationUiState())


    fun validInput(user: String, pass: String): Boolean {
        if (user == "" || pass == "") {
            return false
        }
        return true
    }



    private val db = Firebase.firestore

    fun submitError(error: String, user: String) {

        val newError = hashMapOf(
            "errorMessage" to error,
            "user"         to user
        )
        db  .collection("errors")
            .document()
            .set(newError)
            .addOnSuccessListener {  }
            .addOnFailureListener {  }
    }

    // on below line we are calling method to display UI
    //firebaseUI(LocalContext.current, courseList)
    fun getOgFromDatabase(s: String) {

        viewModelScope.launch {
            val organisation = Organisation()
            val db = FirebaseFirestore.getInstance()
            val docRef = db.collection("Organization").document(s)
            docRef.get().addOnSuccessListener { documentSnapshot ->
                organisation.description = documentSnapshot.get("description") as String
                organisation.subheading = documentSnapshot.get("subheading") as String
                organisation.theme = documentSnapshot.get("theme") as String
                organisation.news = documentSnapshot.get("nyheder") as? String
                organisation.name = documentSnapshot.id
                organisationState.value = organisationState.value.copy(organisation)
                Log.d(TAG, "Organisation $organisation")
            }
        }
    }
    @Composable
    fun hyperLinkText(
        modifier: Modifier,
        fulltext: String,
        linkText: List<String>,
        linkTextColor: Color = Color.Blue,
        linkTextFontWeight: FontWeight = FontWeight.Medium,
        linkTextDecoration: TextDecoration = TextDecoration.Underline,
        hyperlink: List<String>,
        fontSize: TextUnit = TextUnit.Unspecified
    ){
        val annotatedString = buildAnnotatedString {
            linkText.forEachIndexed { index, link ->
                append(fulltext)
                val startIndex = fulltext.indexOf(link)
                val endIndex = startIndex+link.length
                addStyle(
                    style = SpanStyle(
                        color = linkTextColor,
                        fontSize = fontSize,
                        fontWeight = linkTextFontWeight,
                        textDecoration = linkTextDecoration
                    ),
                    start = startIndex,
                    end = endIndex
                )
                addStringAnnotation(
                    tag = "URL",
                    annotation = hyperlink[index],
                    start = startIndex,
                    end = endIndex
                )
            }
            addStyle(
                style = SpanStyle(
                    fontSize = fontSize
                ),
                start = 0,
                end = fulltext.length
            )
        }
        val uriHandler = LocalUriHandler.current
        ClickableText(
            text = annotatedString,
            onClick = {
                annotatedString
                    .getStringAnnotations("URL",it,it)
                    .firstOrNull()?.let { stringAnnotation ->
                        uriHandler.openUri(stringAnnotation.item)
                    }
            })
    }


}