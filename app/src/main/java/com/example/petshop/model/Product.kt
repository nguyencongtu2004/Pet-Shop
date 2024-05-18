package com.example.petshop.model

import androidx.compose.ui.graphics.painter.Painter
import com.example.petshop.R

open class Product(
    var id : String = "nothing",
    var name:String = "Sản phẩm",
    var description: String = "",
    var detailDescription: String = "",
    var image: Int = R.drawable.avt,
    var price: Double = 0.0,
    var oldPrice: Double = 0.0,
    var quantity: Int = 0,
    var star: Double = 0.0,
)

class FoodProduct(
    id: String = "nothing",
    name: String = "Thức ăn",
    description: String = "",
    detailDescription: String = "",
    image: Int = R.drawable.avt,
    price: Double = 0.0,
    oldPrice: Double = 0.0,
    quantity: Int = 0,
    star: Double = 0.0,

    // Phân loại để chọn mua (ví dụ 1kg, 2kg, vị thịt, vị cá...)
    var weight: Double = 0.0,
    var flavor: String = ""
) : Product(id, name, description, detailDescription, image, price, oldPrice, quantity, star)

class ToyProduct(
    id: String = "nothing",
    name: String = "Dụng cụ chơi",
    description: String = "",
    detailDescription: String = "",
    image: Int = R.drawable.avt,
    price: Double = 0.0,
    oldPrice: Double = 0.0,
    quantity: Int = 0,
    star: Double = 0.0,

    // Phân loại để chọn mua
    var something1: Double = 0.0,
    var something2: String = ""
) : Product(id, name, description, detailDescription, image, price, oldPrice, quantity, star)

class ClothesProduct(
    id: String = "nothing",
    name: String = "Quần áo",
    description: String = "",
    detailDescription: String = "",
    image: Int = R.drawable.avt,
    price: Double = 0.0,
    oldPrice: Double = 0.0,
    quantity: Int = 0,
    star: Double = 0.0,

    // Phân loại để chọn mua
    var something3: Double = 0.0,
    var something4: String = ""
) : Product(id, name, description, detailDescription, image, price, oldPrice, quantity, star)