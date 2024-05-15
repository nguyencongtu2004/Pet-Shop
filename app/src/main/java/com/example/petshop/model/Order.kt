package com.example.petshop.model

data class Order(
    var products: List<Product> = listOf(),
    var total: Double = 0.0,

    // Trạng thái đơn hàng
    val isPrepare: Boolean = false,
    val isShipping: Boolean = false,
    val isDelivered: Boolean = false,
)