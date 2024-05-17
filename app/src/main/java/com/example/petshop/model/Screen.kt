package com.example.petshop.model

sealed class Screen(val route: String) {
    object HomePage : Screen(route = "home_page")
    object NotificationScreen : Screen(route = "notification")
    object ShoppingCartScreen : Screen(route = "shopping_cart")
    object ProfileScreen : Screen(route = "profile")
    object EditProfileScreen : Screen(route = "edit_profile")
    object CheckoutScreen : Screen(route = "check_out")
    object ShipmentStateScreen1 : Screen(route = "shipment_state_1")
    object ShipmentStateScreen2 : Screen(route = "shipment_state_2")
    object LoadingCheckout : Screen(route = "loading_checkout")
    object TransactionScreen : Screen(route = "transaction")
    object FollowShipping : Screen(route = "follow_shipping/{orderId}") { // Route with a parameter
        fun createRoute(orderId: String) = "follow_shipping/$orderId"
    }
    object SelectPayMethod : Screen(route = "select_pay_method")
    object SelectVoucher : Screen(route = "select_voucher")
    object ProDuctDetail : Screen(route = "product_detail")
}
