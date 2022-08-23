package com.example.catapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.catapi.controller.SetupOnGraph
import com.example.catapi.model.DataModel
import com.example.catapi.model.MainViewModel
import com.example.catapi.ui.theme.CatApiTheme

class MainActivity : ComponentActivity() {
    val model:MainViewModel by viewModels()
    val dataModel:DataModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController= rememberNavController()
            SetupOnGraph(navController,model,dataModel)
        }
    }
}
