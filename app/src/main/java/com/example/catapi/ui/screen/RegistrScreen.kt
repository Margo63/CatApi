package com.example.catapi.ui.screen

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavHostController
import com.example.catapi.controller.saveData
import com.example.catapi.model.DataModel
import com.example.catapi.model.Screen

@Composable
fun RegistrScreen(navController: NavHostController,dataModel: DataModel) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var checkLogin by remember{ mutableStateOf(false) }
    val context = LocalContext.current
    var checkTint by remember{
        mutableStateOf(Color.Gray)
    }
    var transform by remember {
        mutableStateOf<VisualTransformation>(PasswordVisualTransformation())
    }
    Column(modifier = Modifier.fillMaxSize().background(Color.White), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(100.dp))
        TextField(
            value = login,
            onValueChange = {
                login = it
//                for( i in 0..it.length){
//                    if(it[i].isUpperCase()){
//
//                        login[i] = it[i].toLowerCase()
//                    }
//            }
                 },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = {Text(dataModel.login)}
        )
        Spacer(Modifier.height(25.dp))
        TextField(

            value = password,
            onValueChange = { password = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            trailingIcon = {
                IconButton(onClick = {
                    if(checkLogin){
                        checkLogin=false
                        checkTint=Color.Gray
                        transform=PasswordVisualTransformation()
                    }else{
                        checkLogin=true
                        checkTint=Color.Blue
                        transform= VisualTransformation.None
                    }
                }){

                    Icon(imageVector = Icons.Default.Star,contentDescription = null,tint=checkTint)
                }
            },
            visualTransformation=transform,



        )

        Button(onClick = {
            if( password.length>=7  && password.isDigitsOnly() && login.matches(Regex("\\w{0,16}"))){
                dataModel.onLoginChange(login)
                saveData(context,"login",dataModel.login)
                navController.navigate(Screen.Main.route)
            }else{
             //   Log.d("PASSWORD",password)
               // Log.d("LOGIN",login)
            }

        }){
            Text("вход")
        }
    }

}