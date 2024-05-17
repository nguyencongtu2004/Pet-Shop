package com.example.petshop.view_model

import androidx.lifecycle.ViewModel
import com.example.petshop.model.Product


class CartViewModel : ViewModel() {

    var selectedProducts: List<Product> = listOf()
        private set

    fun setSelectedProducts(products: List<Product>) {
        selectedProducts = products
    }

    var productInCart: List<Product> = listOf(
        Product(
            name = "Đồ ăn",
            description = "Cho chó",
            price = 12000.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
        ),
        Product(
            name = "Đồ ăn",
            description = "Cho chó",
            price = 12000.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
        ),
    )
        private set

}