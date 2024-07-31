package com.example.jetpackcomposetutorial2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial2.ui.theme.JetpackComposeTutorial2Theme

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorial2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageCompose(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ButtonCompose(name: String, modifier: Modifier = Modifier) {

    val context = LocalContext.current.applicationContext
    Column(
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
      Button(onClick = { Toast.makeText(context, "Login Successfully", Toast.LENGTH_LONG) },
             shape = RoundedCornerShape(size = 16.dp),
             colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) {
          Text(text = "Login")
      }
    }
}

@Composable
fun ImageCompose(name: String, modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Image")
}

@Preview(showBackground = true)
@Composable
fun ButtonComposePreview() {
    JetpackComposeTutorial2Theme {
        ImageCompose("Android")
    }
}