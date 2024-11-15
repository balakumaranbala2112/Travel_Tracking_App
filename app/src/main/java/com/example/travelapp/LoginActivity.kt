package com.example.travelapp

import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore
import android.util.Log
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalConfiguration
import androidx.core.content.ContextCompat
import com.google.firebase.firestore.ktx.firestore

class LoginActivity : ComponentActivity() {
    private lateinit var databaseHelper: UserDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databaseHelper = UserDatabaseHelper(this)
        setContent {
            LoginScreen(this, databaseHelper)
        }
    }
}

@Composable
fun LoginScreen(context: Context, databaseHelper: UserDatabaseHelper) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    val db = Firebase.firestore
    val user = hashMapOf(
        "username" to username,
        "password" to password
    )

// Add a new document with a generated ID
    db.collection("users")
        .add(user)
        .addOnSuccessListener { documentReference ->
            Log.d("LoginActivity", "DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            Log.w("LoginActivity", "Error adding document", e)
        }
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val textFieldWidth = if (screenWidth < 400) 260.dp else 300.dp
    val buttonWidth = if (screenWidth < 400) 220.dp else 250.dp

    Box(modifier = Modifier.fillMaxSize()) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.trav),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Dark overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                fontSize = (if (screenWidth < 400) 28.sp else 34.sp),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                color = Color.White,
                text = "Login"
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Username TextField
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier
                    .padding(10.dp)
                    .width(textFieldWidth)
                    .clip(RoundedCornerShape(12.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White.copy(alpha = 0.9f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Password TextField
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .padding(10.dp)
                    .width(textFieldWidth)
                    .clip(RoundedCornerShape(12.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White.copy(alpha = 0.9f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            // Error message
            if (error.isNotEmpty()) {
                Text(
                    text = error,
                    color = MaterialTheme.colors.error,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }

            // Login Button
            Button(
                onClick = {
                    if (username.isNotEmpty() && password.isNotEmpty()) {
                        val user = databaseHelper.getUserByUsername(username)
                        if (user != null && user.password == password) {
                            error = ""
                            context.startActivity(
                                Intent(context, MainActivity::class.java)
                            )
                        } else {
                            error = "Invalid username or password"
                        }
                    } else {
                        error = "Please fill in all fields"
                    }
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .width(buttonWidth)
                    .height(48.dp)
                    .clip(RoundedCornerShape(12.dp)),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF0A74DA))
            ) {
                Text(text = "Login", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(onClick = {
                    context.startActivity(Intent(context, RegisterActivity::class.java))
                }) {
                    Text(text = "Register", color = Color.White)
                }

                TextButton(onClick = { /* Handle Forgot Password */ }) {
                    Text(text = "Forgot password?", color = Color.White)
                }
            }
        }
    }
}