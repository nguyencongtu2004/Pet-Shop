package com.example.petshop.model

import androidx.lifecycle.ViewModel

sealed class Screen(val route: String) {
    object HomePage : Screen(route = "home_page")
    object NotificationScreen : Screen(route = "notification")
    object ShoppingCartScreen : Screen(route = "shopping_cart")
    object ProfileScreen : Screen(route = "profile")


    object EditProfileScreen : Screen(route = "edit_profile")
    object CheckoutScreen: Screen(route = "check_out")

    object ShipmentStateScreen1: Screen(route = "shipment_state_1")
    object ShipmentStateScreen2: Screen(route = "shipment_state_2")

    object LoadingCheckout: Screen(route = "loading_checkout")
    object TransactionScreen: Screen(route = "transaction")
    object FollowShipping: Screen(route = "follow_shipping")

    object SelectPayMethod: Screen(route = "select_pay_method")
    object SelectVoucher: Screen(route = "select_voucher")


}

class CartViewModel : ViewModel() {
    var selectedProducts: List<Product> = listOf()
        private set

    fun setSelectedProducts(products: List<Product>) {
        print("setSelectedProducts")
        selectedProducts = products
    }

    fun addProduct(product: Product) {
        selectedProducts = selectedProducts + product
    }

    fun removeProduct(product: Product) {
        selectedProducts = selectedProducts - product
    }

}