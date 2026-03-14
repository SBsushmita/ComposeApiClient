package com.example.composeapiclient.data.remote

import com.example.composeapiclient.data.dto.UserDto
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getUsers(): List<UserDto>
}




