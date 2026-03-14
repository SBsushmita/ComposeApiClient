package com.example.composeapiclient.presentation.route

sealed class Route(val screen: String) {
    object Home: Route("home")
    object Profile: Route("profile")
    object Settings: Route("settings")
}