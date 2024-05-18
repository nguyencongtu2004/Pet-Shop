package com.example.petshop.view_model

import androidx.lifecycle.ViewModel
import com.example.petshop.model.ClothesProduct
import com.example.petshop.model.FoodProduct
import com.example.petshop.model.Product
import com.example.petshop.model.ToyProduct
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductViewModel : ViewModel() {
    private var _selectedProduct = MutableStateFlow<Product?>(null)
    var selectedProduct: StateFlow<Product?> = _selectedProduct.asStateFlow()


    private var _allProducts = MutableStateFlow<List<Product>>(listOf(
        FoodProduct(
            id = "1",
            name = "Đồ ăn cho chó",
            description = "Thơm ngon, bổ dưỡng",
            price = 15000.0,
            oldPrice = 20000.0,
            star = 4.8,
            quantity = 1,
        ),
        FoodProduct(
            id = "2",
            name = "Đồ ăn cho mèo",
            description = "Mèo rất thích ăn nó",
            price = 12000.0,
            oldPrice = 16000.0,
            star = 4.5,
            quantity = 1,
        ),
        ToyProduct(
            id = "3",
            name = "Máy chơi game PS5",
            description = "Chơi game cực đã",
            price = 50000.0,
            oldPrice = 60000.0,
            star = 4.7,
            quantity = 1,
        ),
        ClothesProduct(
            id = "4",
            name = "Quần áo mèo cutee",
            description = "Mèo mặc vào xinh lắm",
            price = 87000.0,
            oldPrice = 100000.0,
            star = 5.0,
            quantity = 1,
        ),
    ))
    var allProducts: StateFlow<List<Product>> = _allProducts.asStateFlow()


}