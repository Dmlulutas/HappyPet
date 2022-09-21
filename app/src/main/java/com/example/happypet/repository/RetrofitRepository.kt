package com.example.happypet.repository

import com.example.happypet.model.CharResponse
import com.example.happypet.retrofit.IApiInterface
import retrofit2.Response
import javax.inject.Inject

class RetrofitRepository
@Inject constructor(private val apiInterface: IApiInterface) {

   suspend fun getCharacters(page:Int) : Response<CharResponse> = apiInterface.getCharacters(page)

}