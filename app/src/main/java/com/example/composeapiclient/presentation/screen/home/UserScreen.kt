package com.example.composeapiclient.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeapiclient.core.Resource
import com.example.composeapiclient.domain.model.User
import com.example.composeapiclient.presentation.viewmodel.UserViewModel

@Composable
fun UserScreen(userViewModel: UserViewModel = hiltViewModel(),
               onUserClick: (User) -> Unit) {
    val state = userViewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        when (state.value) {

            is Resource.Loading -> {
                CircularProgressIndicator()
            }

            is Resource.Success -> {
                val users = (state.value as Resource.Success).data
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(users) { user ->
                        UserItem(user,
                            onUserClick = {selectedUser ->
                                onUserClick(selectedUser)
                            })
                    }
                }
            }


            is Resource.Error -> {
                val errorMessage = (state.value as Resource.Error).message
                Text(text = errorMessage,
                    color = Color.Red,
                    textAlign = TextAlign.Center
                )

            }

        }

    }

}

@Preview
@Composable
fun UserScreenPreview() {
    UserScreen(
        userViewModel = TODO(),
        onUserClick = TODO()
    )
}