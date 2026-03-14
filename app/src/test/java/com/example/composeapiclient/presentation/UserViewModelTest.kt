package com.example.composeapiclient.presentation

import com.example.composeapiclient.core.Resource
import com.example.composeapiclient.domain.model.User
import com.example.composeapiclient.domain.usecase.GetUsersUseCase
import com.example.composeapiclient.presentation.viewmodel.UserViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModelTest {
    private val useCase: GetUsersUseCase = mockk()
    lateinit var viewModel: UserViewModel

    @Before
    fun setUp(){
        viewModel = UserViewModel(useCase)
    }

    @Test
    fun `get users for viewModel from UseCase`() = runTest {
//        val users = Resource.Success(listOf(User(1, "Sushmita", "Sush", "abc@gmail.com")))
//        coEvery { useCase() } returns users
//        val result = viewModel.uiState.value
//        assertEquals(users, result)
//        coVerify { useCase() }

    }
}