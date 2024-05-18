package com.example.petshop.view_model

import androidx.lifecycle.ViewModel
import com.example.petshop.R
import com.example.petshop.model.ClothesProduct
import com.example.petshop.model.Flavor
import com.example.petshop.model.FoodProduct
import com.example.petshop.model.Product
import com.example.petshop.model.Size
import com.example.petshop.model.ToyProduct
import com.example.petshop.model.Weight
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
class ProductViewModel : ViewModel() {
    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct: StateFlow<Product?> = _selectedProduct.asStateFlow()

    private val _allProducts = MutableStateFlow<List<Product>>(listOf(
        FoodProduct(
            id = "1",
            name = "Đồ ăn cho chó",
            description = "Thơm ngon, bổ dưỡng",
            price = 15000.0,
            oldPrice = 20000.0,
            star = 4.8,
            quantity = 1,
            image = R.drawable.avt,
            detailDescription = "Chi tiết sản phẩm"
        ),
        FoodProduct(
            id = "2",
            name = "Đồ ăn cho mèo",
            description = "Mèo rất thích ăn nó",
            price = 12000.0,
            oldPrice = 16000.0,
            star = 4.5,
            quantity = 1,
            image = R.drawable.avt,
            detailDescription = "Chi tiết sản phẩm"
        ),
        ToyProduct(
            id = "3",
            name = "Máy chơi game PS5",
            description = "Chơi game cực đã",
            price = 50000.0,
            oldPrice = 60000.0,
            star = 4.7,
            quantity = 1,
            image = R.drawable.avt,
            detailDescription = "Chi tiết sản phẩm"
        ),
        ClothesProduct(
            id = "4",
            name = "Quần áo mèo cutee",
            description = "Mèo mặc vào xinh lắm",
            price = 87000.0,
            oldPrice = 100000.0,
            star = 5.0,
            quantity = 1,
            image = R.drawable.avt,
            detailDescription = "Chi tiết sản phẩm"
        )
    ))
    val allProducts: StateFlow<List<Product>> = _allProducts.asStateFlow()

    fun setSelectedProduct(product: Product) {
        _selectedProduct.value = product
    }

    fun setFlavor(flavor: Flavor) {
        val currentProduct = _selectedProduct.value
        if (currentProduct is FoodProduct) {
            _selectedProduct.value = currentProduct.copy(selectedFlavor = flavor)
        }
    }

    fun setWeight(weight: Weight) {
        val currentProduct = _selectedProduct.value
        if (currentProduct is FoodProduct) {
            _selectedProduct.value = currentProduct.copy(selectedWeight = weight)
        }
    }

    fun setSize(size: Size) {
        when (val currentProduct = _selectedProduct.value) {
            is ToyProduct -> _selectedProduct.value = currentProduct.copy(selectedSize = size)
            is ClothesProduct -> _selectedProduct.value = currentProduct.copy(selectedSize = size)
            is FoodProduct -> TODO()
            null -> TODO()
        }
    }

    fun toggleFavorite() {
        _selectedProduct.update {
            it?.let { product ->
                when (product) {
                    is FoodProduct -> product.copy(isFavorite = !product.isFavorite)
                    is ToyProduct -> product.copy(isFavorite = !product.isFavorite)
                    is ClothesProduct -> product.copy(isFavorite = !product.isFavorite)
                }
            }
        }
    }
}
