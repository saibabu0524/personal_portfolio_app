package com.example.personalportifolioapp

sealed class Screen(val route :String){
    object ProfileScreen :Screen("profile_screen")
    object AddProfileScreen : Screen("profile_edit_screen")
}
