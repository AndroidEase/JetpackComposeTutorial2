package com.example.jetpackcomposetutorial2.navigationdrawer

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposetutorial2.ScreensBottomSheet
import com.example.jetpackcomposetutorial2.ui.theme.GreenJC
import com.example.jetpackcomposetutorial2.ui.theme.JetpackComposeTutorial2Theme

class BottomNavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorial2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BottomAppBarCompose(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomAppBarCompose(name: String, modifier: Modifier = Modifier) {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember {
        mutableStateOf(false)
    }


    Scaffold(
        bottomBar = {
            BottomAppBar(contentColor = GreenJC) {
                // Home
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navigationController.navigate(ScreensBottomSheet.Home.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Home, contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Home) GreenJC else Color.Gray)
                }
                // Search
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Search
                        navigationController.navigate(ScreensBottomSheet.Search.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Search, contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Search) GreenJC else Color.Gray)
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                        contentAlignment = Alignment.Center) {
                    FloatingActionButton(onClick = {
                        showBottomSheet = true
                    }) {
                        Icon(Icons.Default.Add, contentDescription = null, tint =  GreenJC)
                    }
                }

                // Notification
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Notifications
                        navigationController.navigate(ScreensBottomSheet.Notification.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Notifications, contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Notifications) GreenJC else Color.Gray)
                }

                // Profile
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navigationController.navigate(ScreensBottomSheet.Profile.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Person, contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Person) GreenJC else Color.Gray)
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navigationController,
            startDestination = ScreensBottomSheet.Home.screen,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(ScreensBottomSheet.Home.screen) {
                ScreensBottomSheet.Home
            }
            composable(ScreensBottomSheet.Search.screen) {
                ScreensBottomSheet.Search
            }
            composable(ScreensBottomSheet.Notification.screen) {
                ScreensBottomSheet.Notification
            }
            composable(ScreensBottomSheet.Profile.screen) {
                ScreensBottomSheet.Profile
            }
            composable(ScreensBottomSheet.Post.screen) {
                ScreensBottomSheet.Post
            }
        }

        if(showBottomSheet) {
            ModalBottomSheet(onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp))  {

                    BottomSheetItem(icon = Icons.Default.ThumbUp,
                        title = "Create A Post" ) {
                        showBottomSheet = false
                        navigationController.navigate(ScreensBottomSheet.Post.screen) {
                            popUpTo(0)
                        }
                    }

                    BottomSheetItem(icon = Icons.Default.ThumbUp,
                        title = "Add a Story" ) {
                        Toast.makeText(context, "Add a Story", Toast.LENGTH_LONG).show()
                    }

                    BottomSheetItem(icon = Icons.Default.Favorite,
                        title = "Go Live" ) {
                        Toast.makeText(context, "Live", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}

@Composable
fun BottomSheetItem(icon : ImageVector, title : String, onclick : () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement =  Arrangement.spacedBy(12.dp),
        modifier = Modifier.clickable { onclick }) {
        Icon(icon, contentDescription = null, tint = GreenJC)
        Text(text = title, color = GreenJC)
    }
}

@Preview(showBackground = true)
@Composable
fun BottomAppBarPreview() {
    JetpackComposeTutorial2Theme {
        BottomAppBarCompose("Android")
    }
}


