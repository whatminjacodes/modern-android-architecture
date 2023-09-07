package com.example.modernmvvmarchitecture

// Kinda like enum
sealed class Route(val route: String) {
    object Home: Route("Home")
    object Detail: Route("Detail/{productId}") {
        fun createRoute(productId: Int) = "Detail/$productId"
    }
}