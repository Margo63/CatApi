package com.example.catapi.controller

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.catapi.model.DataModel
import com.example.catapi.model.MainViewModel
import com.example.catapi.model.Screen
import com.example.catapi.ui.screen.MainScreen
import com.example.catapi.ui.screen.RegistrScreen

@Composable
fun SetupOnGraph(navController:NavHostController,model:MainViewModel,dataModel: DataModel){
    val login = readData(LocalContext.current,"login")
    dataModel.onLoginChange(login)

    var route_now by remember {mutableStateOf("")}

    if(dataModel.login=="ERROR")
        route_now = Screen.Registr.route
    else{route_now = Screen.Registr.route}


    NavHost(
            navController, route_now){
        composable(Screen.Registr.route){
            RegistrScreen(navController,dataModel)
        }
        composable(Screen.Main.route){
            MainScreen(navController,model)
        }
    }

}