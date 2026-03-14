package com.example.composeapiclient.domain

import com.example.composeapiclient.core.Resource
import com.example.composeapiclient.domain.model.User
import com.example.composeapiclient.domain.repository.UserRepository
import com.example.composeapiclient.domain.usecase.GetUsersUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetUsersUseCaseTest {
    private val repository: UserRepository = mockk()
    private lateinit var usecase: GetUsersUseCase

    @Before
    fun setUp(){
        usecase = GetUsersUseCase(repository)
    }

    @Test
    fun `return users list from repository`() = runTest{

        val users = Resource.Success(
            listOf(
                User(
                    id = 1,
                    name = "Test User",
                    username = "testuser",
                    email = "test@gmail.com"
                )
            )
        )
        coEvery{ repository.getUsers() } returns users
        val result = usecase()
        assertEquals(users, result)
        coVerify { repository.getUsers() }
    }
}