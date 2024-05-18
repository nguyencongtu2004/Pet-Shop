package com.example.petshop.model

import com.example.petshop.R

enum class Weight(val value: String) {
    _0_5KG("0.5 kg"), _1KG("1 kg"), _1_5KG("1.5 kg"), _2KG("2 kg")
}

enum class Flavor(val value: String) {
    BEEF("Bò"), FISH("Cá hồi"), CHICKEN("Gà"), PORK("Heo")
}

enum class Size(val value: String) {
    S("S"), M("M"), L("L"), XL("XL")
}


open class Product(
    var id : String = "nothing",
    var name:String = "Sản phẩm",
    var tag: List<String> = listOf(),
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
    tag: List<String> = listOf("Thức ăn"),
    description: String = "",
    detailDescription: String = "",
    image: Int = R.drawable.avt,
    price: Double = 0.0,
    oldPrice: Double = 0.0,
    quantity: Int = 0,
    star: Double = 0.0,

    // Phân loại để chọn mua (ví dụ 1kg, 2kg, vị thịt, vị cá...)
    var selectedWeight: Weight = Weight._0_5KG,
    var selectedFlavor: Flavor = Flavor.BEEF,
) : Product(id, name, tag, description, detailDescription, image, price, oldPrice, quantity, star)

class ToyProduct(
    id: String = "nothing",
    name: String = "Dụng cụ chơi",
    tag: List<String> = listOf("Đồ chơi"),
    description: String = "",
    detailDescription: String = "",
    image: Int = R.drawable.avt,
    price: Double = 0.0,
    oldPrice: Double = 0.0,
    quantity: Int = 0,
    star: Double = 0.0,

    // Phân loại để chọn mua
    var selectedSize: Size = Size.S,
) : Product(id, name, tag, description, detailDescription, image, price, oldPrice, quantity, star)

class ClothesProduct(
    id: String = "nothing",
    name: String = "Quần áo",
    tag: List<String> = listOf("Quần áo"),
    description: String = "",
    detailDescription: String = "",
    image: Int = R.drawable.avt,
    price: Double = 0.0,
    oldPrice: Double = 0.0,
    quantity: Int = 0,
    star: Double = 0.0,

    // Phân loại để chọn mua
    var selectedSize: Size = Size.S,
) : Product(id, name, tag, description, detailDescription, image, price, oldPrice, quantity, star)