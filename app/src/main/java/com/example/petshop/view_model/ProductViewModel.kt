package com.example.petshop.view_model

import androidx.lifecycle.ViewModel
import com.example.petshop.model.Product

class ProductViewModel : ViewModel() {
    var products: List<Product> = listOf()
        private set
    

}