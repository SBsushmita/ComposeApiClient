package com.example.composeapiclient.data

import com.example.composeapiclient.core.Resource
import com.example.composeapiclient.data.dto.UserDto
import com.example.composeapiclient.data.remote.ApiService
import com.example.composeapiclient.data.repository.UserRepositoryImpl
import com.example.composeapiclient.domain.model.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserRepositoryImplTest {
    private val apiService: ApiService = mockk()
    private lateinit var repositoryImpl: UserRepositoryImpl

    @Before
    fun setUP(){
        repositoryImpl = UserRepositoryImpl(apiService)
    }

    @Test
    fun `get users from ApiService`()= runTest {
        val userDto = listOf<UserDto>(UserDto(1, "abc@gmail.com", "Sush", "category", "Sushmita"))
        coEvery { apiService.getUsers() } returns userDto
        val expectedUsers = userDto.map{ dto ->
            User(
                id = dto.id,
                name = dto.title,
                username =  dto.description,
                email =  dto.image
            )
        }
        val result = repositoryImpl.getUsers()
        assertEquals(expectedUsers,  (result as Resource.Success).data)
        coVerify { apiService.getUsers() }
    }
}