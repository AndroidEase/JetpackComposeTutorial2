package com.example.jetpackcomposetutorial2.navigationdrawer

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposetutorial2.Screens
import com.example.jetpackcomposetutorial2.ui.theme.GreenJC
import com.example.jetpackcomposetutorial2.ui.theme.JetpackComposeTutorial2Theme
import kotlinx.coroutines.launch

class NavDrawerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorial2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavDrawerCompopse(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavDrawerCompopse(name: String, modifier: Modifier = Modifier) {
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    Log.d("TAG", "Profile Screen Nav Drawer Activity")

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(modifier = Modifier
                    .background(GreenJC)
                    .fillMaxWidth()
                    .height(150.dp)){
                }
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Home", color = GreenJC ) },
                    selected = false,
                    icon = { Icon(imageVector =  Icons.Default.Home, contentDescription = "cd", tint = GreenJC )},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Home.screen) {
                            popUpTo(0)
                        }
                    })
                NavigationDrawerItem(
                    label = { Text(text = "Profile", color = GreenJC ) },
                    selected = false,
                    icon = { Icon(imageVector =  Icons.Default.Person, contentDescription = "cd", tint = GreenJC )},
                    onClick = {
                        Log.d("TAG", "Profile Screen Entry")

                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Profile.screen) {
                            popUpTo(0)
                        }
                    })
                NavigationDrawerItem(
                    label = { Text(text = "Settings", color = GreenJC ) },
                    selected = false,
                    icon = { Icon(imageVector =  Icons.Default.Settings, contentDescription = "cd", tint = GreenJC )},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Settings.screen) {
                            popUpTo(0)
                        }
                    })
                NavigationDrawerItem(
                    label = { Text(text = "Logout", color = GreenJC ) },
                    selected = false,
                    icon = { Icon(imageVector =  Icons.Default.ExitToApp, contentDescription = "cd", tint = GreenJC )},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context, "Loggedout", Toast.LENGTH_LONG).show()
                    })
            }
        }
    ) {
        Scaffold (
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(title = { Text(text = "WhatsApp") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = GreenJC,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(Icons.Rounded.Menu, contentDescription = "Menu")
                        }
                    })
            }
        ) {
            NavHost(navigationController, startDestination = Screens.Home.screen) {
                composable(Screens.Home.screen) {
                    Screens.Home
                }
                composable(Screens.Profile.screen) {
                    Screens.Profile
                }
                composable(Screens.Settings.screen) {
                    Screens.Settings
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorial2Theme {
        NavDrawerCompopse("Android")
    }
}