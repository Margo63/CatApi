package com.example.catapi.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.catapi.model.MainViewModel
import com.example.catapi.model.Screen
import com.example.catapi.model.cat.CatItem

@Composable
fun MainScreen(navController:NavHostController,model:MainViewModel){
    model.getCat()
    var isFavorite by remember{
        mutableStateOf(Color.Gray)
    }
    val cats:List<CatItem> = model.catResponse
    Box(modifier = Modifier.fillMaxSize().background(Color.Cyan)){
        LazyColumn {
            items(cats.size){index ->
                Card(modifier=Modifier.fillMaxWidth()){
                    Row{
                      Image(rememberAsyncImagePainter(cats[index].image.url),contentDescription = null,modifier=Modifier.size(129.dp))
                        Text(cats[index].name)
                        IconButton(onClick = {isFavorite=Color.Red
                                             model.postFavorites(cats[index].image.id)
                                           // Log.d("FAVORITE",)
                                             },){
                            Icon(Icons.Default.Favorite,tint=isFavorite, contentDescription = null)
                        }
                    }
                }
            }
        }
    }
}


