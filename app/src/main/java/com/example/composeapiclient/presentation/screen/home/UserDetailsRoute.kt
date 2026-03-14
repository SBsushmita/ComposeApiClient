package com.example.composeapiclient.presentation.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeapiclient.core.Resource
import com.example.composeapiclient.domain.model.User
import com.example.composeapiclient.presentation.viewmodel.UserViewModel

@Composable
fun UserDetailsRoute(userId: Int?) {
    val viewModel: UserViewModel = hiltViewModel()

    val state by viewModel.uiState.collectAsState()

    val user = when (state) {

        is Resource.Success -> {
            val users = (state as Resource.Success<List<User>>).data
            users.find { it.id == userId }
        }

        else -> null
    }

    user?.let {
        UserDetailsScreen(user = it)
    }


}