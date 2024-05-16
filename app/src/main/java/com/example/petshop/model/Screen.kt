package com.example.petshop.model

sealed class Screen(val route: String) {
    object HomePage : Screen(route = "home_page")
    object NotificationScreen : Screen(route = "notification")
    object ShoppingCartScreen : Screen(route = "shopping_cart")
    object ProfileScreen : Screen(route = "profile")

    object Checkout : Screen(route = "checkout")
    object EditProfileScreen : Screen(route = "edit_profile")
    object CheckoutScreen: Screen(route = "check_out")


}