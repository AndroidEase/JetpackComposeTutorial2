package com.example.jetpackcomposetutorial2


// It has predefined sub classes
sealed class ScreensBottomSheet(val screen  : String) {
    data object Home : ScreensBottomSheet("home")
    data object Search : ScreensBottomSheet("search")
    data object Notification : ScreensBottomSheet("notification")
    data object Profile : ScreensBottomSheet("profile")
    data object Post : ScreensBottomSheet("post")
}