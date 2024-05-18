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


sealed class Product {
    abstract var id: String
    abstract var name: String
    abstract var description: String
    abstract var detailDescription: String
    abstract var tags: List<String>
    abstract var image: Int
    abstract var price: Double
    abstract var oldPrice: Double
    abstract var star: Double
    abstract var quantity: Int
    abstract var isFavorite: Boolean
}

data class FoodProduct(
    override var id: String,
    override var name: String,
    override var description: String,
    override var detailDescription: String,
    override var tags: List<String> = listOf("food", "dog"),
    override var image: Int,
    override var price: Double,
    override var oldPrice: Double,
    override var star: Double,
    override var quantity: Int,
    override var isFavorite: Boolean = false,
    var selectedFlavor: Flavor = Flavor.BEEF,
    var selectedWeight: Weight = Weight._0_5KG
) : Product()

data class ToyProduct(
    override var id: String,
    override var name: String,
    override var description: String,
    override var detailDescription: String,
    override var tags: List<String> = listOf("toy", "game"),
    override var image: Int,
    override var price: Double,
    override var oldPrice: Double,
    override var star: Double,
    override var quantity: Int,
    override var isFavorite: Boolean = false,
    var selectedSize: Size = Size.S
) : Product()

data class ClothesProduct(
    override var id: String,
    override var name: String,
    override var description: String,
    override var detailDescription: String,
    override var tags: List<String> = listOf("clothes", "cat"),
    override var image: Int,
    override var price: Double,
    override var oldPrice: Double,
    override var star: Double,
    override var quantity: Int,
    override var isFavorite: Boolean = false,
    var selectedSize: Size = Size.S
) : Product()