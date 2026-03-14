package com.example.composeapiclient.data.repository

import com.example.composeapiclient.core.Resource
import com.example.composeapiclient.data.mapper.toUser
import com.example.composeapiclient.data.remote.ApiService
import com.example.composeapiclient.domain.model.User
import com.example.composeapiclient.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: ApiService): UserRepository {
    override suspend fun getUsers(): Resource<List<User>>{
        return try {

            val users = apiService.getUsers().map { it.toUser() }

            Resource.Success(users)

        } catch (e: Exception) {

            Resource.Error(e.message ?: "Unknown error")
        }
    }
}