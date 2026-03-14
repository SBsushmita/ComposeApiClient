package com.example.composeapiclient.domain.usecase

import com.example.composeapiclient.core.Resource
import com.example.composeapiclient.domain.model.User
import com.example.composeapiclient.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(): Resource<List<User>> {
        return userRepository.getUsers()
    }
}

