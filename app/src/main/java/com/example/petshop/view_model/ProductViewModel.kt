package com.example.petshop.view_model

import androidx.lifecycle.ViewModel
import com.example.petshop.model.Product

class ProductViewModel : ViewModel() {
    var allProducts: List<Product> = listOf(
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