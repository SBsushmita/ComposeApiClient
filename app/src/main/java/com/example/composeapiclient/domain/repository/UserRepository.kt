package com.example.composeapiclient.domain.repository

import com.example.composeapiclient.core.Resource
import com.example.composeapiclient.domain.model.User

interface UserRepository {
    suspend fun getUsers(): Resource<List<User>>
}