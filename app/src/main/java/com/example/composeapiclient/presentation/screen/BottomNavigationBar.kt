package com.example.composeapiclient.presentation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.composeapiclient.presentation.route.Route

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf<Route>(
        Route.Home,
        Route.Profile,
        Route.Settings
    )

    NavigationBar {
        items.forEach { item ->
            val icon = when(item){
                Route.Home -> Icons.Default.Home
                Route.Profile -> Icons.Default.Person
                Route.Settings -> Icons.Default.Settings
            }
            NavigationBarItem(
                selected = false,
                onClick = {
                    navController.navigate(item.screen)
                },
                icon = {
                    Icon(icon, null)
                }
            )
        }
    }

}