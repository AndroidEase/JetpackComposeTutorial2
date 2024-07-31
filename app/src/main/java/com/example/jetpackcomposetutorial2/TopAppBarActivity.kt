package com.example.jetpackcomposetutorial2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.referentialEqualityPolicy
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial2.ui.theme.GreenJC
import com.example.jetpackcomposetutorial2.ui.theme.JetpackComposeTutorial2Theme

class TopAppBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorial2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TopBarCompose(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarCompose(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current.applicationContext
   TopAppBar(title = { Text(text = "WhatsApp") },
       navigationIcon = {
           IconButton(onClick = {

           }) {
               Icon(painter = painterResource(id = R.drawable.whatapp), contentDescription = "WhatsAppIcon" )
           }
       }, colors = TopAppBarDefaults.topAppBarColors(
           containerColor = GreenJC,
           titleContentColor = Color.White,
           navigationIconContentColor = Color.White
       ), actions = {
           IconButton(onClick = {  Toast.makeText(context, "Whats App", Toast.LENGTH_LONG).show() }) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile" , tint = Color.White)
           }
           IconButton(onClick = {  Toast.makeText(context, "Search", Toast.LENGTH_LONG).show() }) {
               Icon(imageVector = Icons.Filled.Search, contentDescription = "Search" , tint = Color.White)
           }
           IconButton(onClick = {  Toast.makeText(context, "Menu", Toast.LENGTH_LONG).show() }) {
               Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menu" , tint = Color.White)
           }
       }
       )
}

@Preview(showBackground = true)
@Composable
fun TopBarComposePreview() {
    JetpackComposeTutorial2Theme {
        TopBarCompose("Android")
    }
}