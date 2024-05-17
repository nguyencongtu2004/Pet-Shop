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
            name = "Đồ ăn cho chó cao cấp",
            description = "Đây là sản phẩm thức ăn cho chó cao cấp",
            price = 19000.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
        ),
        Product(
            name = "Đồ ăn cho mèo",
            description = "Đây là sản phẩm thức ăn cho mèo",
            price = 14500.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
        ),
        Product(
            name = "Đồ chơi cho chó",
            description = "Đây là sản phẩm đồ chơi cho chó",
            price = 25000.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
        ),
        Product(
            name = "Quần áo cho chó",
            description = "Đây là sản phẩm quần áo cho chó",
            price = 35000.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
        ),

    )
        private set

}