package com.example.composeapiclient.presentation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapiclient.presentation.route.Route
import com.example.composeapiclient.presentation.screen.home.UserDetailsRoute
import com.example.composeapiclient.presentation.screen.home.UserScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
val  navController = rememberNavController()

  Scaffold (
      topBar = {
          TopAppBar(
              title = { Text("Compose Demo") }
          )
      },
      bottomBar = {
            BottomNavigationBar(navController)
      },
      floatingActionButton = {
          FloatingActionButton(onClick = {

          }) {
              Icon(Icons.Default.Add, null)
          }
      }
  ){ paddingValues ->
      NavHost(navController = navController,
          startDestination = Route.Home.screen){
          composable(Route.Home.screen) { UserScreen(onUserClick ={
                  user -> navController.navigate("userDetail/${user.id}")
          }) }
          composable("userDetail/{userid}"){ backStackEntry ->
              val userId = backStackEntry
                  .arguments
                  ?.getString("userid")?.toInt()
              UserDetailsRoute(userId)
          }
          composable(Route.Profile.screen) { }
          composable(Route.Settings.screen) {  }

      }
  }
}