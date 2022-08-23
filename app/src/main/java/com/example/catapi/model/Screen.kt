package com.example.catapi.model

sealed class Screen(val route:String) {
    object Registr :Screen("registr_screen")
    object Main:Screen("main_screen")
}