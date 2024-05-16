package com.example.petshop.model

enum class OrderStatus {
    PREPARE,
    SHIPPING,
    DELIVERED
}

data class Order(
    var products: List<Product> = listOf(),
    var total: Double = 0.0,

    var status: OrderStatus = OrderStatus.PREPARE
)