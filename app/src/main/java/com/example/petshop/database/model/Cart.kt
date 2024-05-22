package com.example.petshop.database.model
data class CartItem(
    val id_product: String="null",
    var quantity: Int = 0,
)

data class Cart(
    val id_user: String = "null",
    val items: MutableList<CartItem> = mutableListOf()
)
