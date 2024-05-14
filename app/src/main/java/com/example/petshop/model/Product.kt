package com.example.petshop.model

data class Product(
    var name:String = "",
    var description: String = "",
    var price: Double = 0.0,
    var oldPrice: Double = 0.0,
    var quantity: Int = 0,
    var star: Double = 0.0,
)