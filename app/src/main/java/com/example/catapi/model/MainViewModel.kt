package com.example.catapi.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catapi.controller.RetrofitInterface
import com.example.catapi.model.cat.CatItem
import com.example.catapi.model.favorite.BodyFavorite
import kotlinx.coroutines.launch
import kotlin.Exception

class MainViewModel:ViewModel() {
    var sub_id :String by mutableStateOf("my-user-1234")

    var catResponse:List<CatItem> by mutableStateOf(listOf())
    var messageFavoriteResponse by mutableStateOf("")
    var errorMessage by mutableStateOf("")

    fun getCat(){
        viewModelScope.launch {
            try {
                val apiService = RetrofitInterface.getInstance()
                catResponse=apiService.getCat()
            }catch (e:Exception){
                errorMessage = e.message.toString()
            }
        }
    }

    fun postFavorites(image_id:String){
        viewModelScope.launch {
            try{
                val body=BodyFavorite(image_id,sub_id)
                val result = RetrofitInterface.getInstance().PostFavorite(body)
            }catch (e:Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}