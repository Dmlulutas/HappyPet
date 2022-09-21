package com.example.happypet.retrofit

import com.example.happypet.model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiInterface {

    @GET("character")
    suspend fun getCharacters(@Query("page") query: Int): Response<CharResponse>

    @GET("episode")
    suspend fun getEpisodes(): Response<List<Episode>>


}