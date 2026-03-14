package com.example.composeapiclient.presentation.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composeapiclient.domain.model.User

@Composable
fun UserItem (users: User,
              onUserClick: (User) -> Unit
        ){

    Card (modifier = Modifier.fillMaxWidth()
        .padding(8.dp)
        .clickable{onUserClick(users)},
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ){

        Column(modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = users.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Text(text = users.username,
                fontSize = 14.sp)

            Spacer(modifier = Modifier.padding(4.dp))

            AsyncImage(model = users.email,
                contentDescription = "User Image",
                modifier = Modifier.size(100.dp),
                alignment = Alignment.Center
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun UserItemPreview() {

    val user = User(
        id = 1,
        name = "John Doe",
        username = "johndoe",
        email = "john@example.com"
    )

    UserItem(users = user,
        onUserClick =  {selectedUser ->

        })
}