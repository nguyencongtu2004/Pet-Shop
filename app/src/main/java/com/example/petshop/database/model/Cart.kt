package com.example.petshop.database.model
data class CartItem(
    val id_product: String,
    var quantity: Int = 0
)

data class Cart(
    val id_user: String,
    val items: MutableList<CartItem> = mutableListOf()
)
