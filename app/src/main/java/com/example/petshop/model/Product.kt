package com.example.petshop.model

import androidx.compose.ui.graphics.painter.Painter

open class Product(
    var name:String = "Sản phẩm",
    var description: String = "",
    var image: Painter? = null,
    var price: Double = 0.0,
    var oldPrice: Double = 0.0,
    var quantity: Int = 0,
    var star: Double = 0.0,
)

class FoodProduct(
    name: String = "Thức ăn",
    description: String = "",
    image: Painter? = null,
    price: Double = 0.0,
    oldPrice: Double = 0.0,
    quantity: Int = 0,
    star: Double = 0.0,
    var weight: Double = 0.0,
    var type: String = ""
) : Product(name, description, image, price, oldPrice, quantity, star)