package com.example.catapi.controller

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import com.example.catapi.model.cat.Cat
import com.example.catapi.model.favorite.BodyFavorite
import com.example.catapi.model.favorite.GetPost
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitInterface {
    companion object {
        val BASE_URL by mutableStateOf("https://api.thecatapi.com/")
        const val API_KEY ="live_dNLfNAdpjCCFvSnRTmcvN968fPZrzccwTndgfiqoxoc3EHFyaxjJ2V7pnMheNDHn"
        var apiService: RetrofitInterface? = null
        fun getInstance(): RetrofitInterface {
            if (apiService == null) {
                apiService = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
                    .create(RetrofitInterface::class.java)
            }
            return apiService!!
        }
    }




    @Headers("x-api-key:$API_KEY")
    @GET("v1/breeds?limit=10&page=0")
    //@Query("page") page:Int, @Query("limit") limit:Int
    suspend fun getCat():Cat

    @Headers("x-api-key:$API_KEY")
    @POST("v1/favourites")
    suspend fun PostFavorite(@Body favorite:BodyFavorite):GetPost

}