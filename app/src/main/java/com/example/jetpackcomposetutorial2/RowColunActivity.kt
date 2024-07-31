package com.example.jetpackcomposetutorial2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial2.ui.theme.JetpackComposeTutorial2Theme

class RowColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorial2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RowColumn(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun RowColumn(name: String, modifier: Modifier = Modifier) {

//    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text("Text 1")
//        Text("Text 2")
//    }
//
//    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
//        Text("Text 3")
//        Text("Text 4")
//    }

    Box(modifier = Modifier.fillMaxSize().background(Color.Yellow), contentAlignment = Alignment.Center) {
        Box(modifier = Modifier.height(200.dp).width(200.dp).background(Color.Blue)) {
            Text("Text 3", modifier = Modifier.align(Alignment.Center), Color.White)
        }
    }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter) {
        Text(text = "Box Alignment", modifier = Modifier.align(Alignment.Center))
    }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter) {
        Text(text = "TopStart" , modifier = Modifier.align(Alignment.TopStart))
        Text(text = "TopCenter" , modifier = Modifier.align(Alignment.TopCenter))
        Text(text = "TopRight" , modifier = Modifier.align(Alignment.TopEnd))
        Text(text = "BottomStart" , modifier = Modifier.align(Alignment.BottomStart))
        Text(text = "BottomCenter" , modifier = Modifier.align(Alignment.BottomCenter))
        Text(text = "BottomEnd" , modifier = Modifier.align(Alignment.BottomEnd))
        Text(text = "CenterStart" , modifier = Modifier.align(Alignment.CenterStart))
        Text(text = "Center" , modifier = Modifier.align(Alignment.Center))
        Text(text = "CenterEnd" , modifier = Modifier.align(Alignment.CenterEnd))
    }

}

@Preview(showBackground = true)
@Composable
fun RowColumnPreview() {
    JetpackComposeTutorial2Theme {
        RowColumn("Android")
    }
}