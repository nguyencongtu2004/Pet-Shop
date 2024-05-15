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

    // Phân loại để chọn mua (ví dụ 1kg, 2kg, vị thịt, vị cá...)
    var weight: Double = 0.0,
    var flavor: String = ""
) : Product(name, description, image, price, oldPrice, quantity, star)

class ToyProduct(
    name: String = "Dụng cụ chơi",
    description: String = "",
    image: Painter? = null,
    price: Double = 0.0,
    oldPrice: Double = 0.0,
    quantity: Int = 0,
    star: Double = 0.0,

    // Phân loại để chọn mua
    var something1: Double = 0.0,
    var something2: String = ""
) : Product(name, description, image, price, oldPrice, quantity, star)

class ClothesProduct(
    name: String = "Quần áo",
    description: String = "",
    image: Painter? = null,
    price: Double = 0.0,
    oldPrice: Double = 0.0,
    quantity: Int = 0,
    star: Double = 0.0,

    // Phân loại để chọn mua
    var something3: Double = 0.0,
    var something4: String = ""
) : Product(name, description, image, price, oldPrice, quantity, star)