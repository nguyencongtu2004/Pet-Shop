package com.example.petshop.view_model

import androidx.lifecycle.ViewModel
import com.example.petshop.model.Product


class CartViewModel : ViewModel() {

    var selectedProducts: List<Product> = listOf()
        private set

    fun setSelectedProducts(products: List<Product>) {
        selectedProducts = products
    }

}