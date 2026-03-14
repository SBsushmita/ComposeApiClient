package com.example.composeapiclient.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.composeapiclient.domain.model.User

@Composable
fun UserDetailsScreen(user: User) {


    Column(modifier = Modifier.fillMaxSize()
        .padding(16.dp)  ){

        Text(text = user.name)
        Spacer(modifier = Modifier.padding(4.dp))

        AsyncImage(model = user.email,
            contentDescription = "User Image",
            modifier = Modifier.size(100.dp),
            alignment = Alignment.Center
        )
    }
}