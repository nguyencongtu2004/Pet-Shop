package com.example.petshop.view_model

import androidx.lifecycle.ViewModel
import com.example.petshop.R
import com.example.petshop.model.ClothesProduct
import com.example.petshop.model.FoodProduct
import com.example.petshop.model.Product
import com.example.petshop.model.ToyProduct
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CartViewModel : ViewModel() {

    private var _selectedProducts = MutableStateFlow<List<Product>>(listOf())
    var selectedProducts: StateFlow<List<Product>> = _selectedProducts.asStateFlow()

    private var _totalAmount = MutableStateFlow(0.0)
    var totalAmount: StateFlow<Double> = _totalAmount.asStateFlow()

    fun addProductToSelected(product: Product) {
        val products = _selectedProducts.value.toMutableList()
        products.add(product)
        _selectedProducts.update { products }
        updateTotalAmount()
    }

    fun resetSelectedProducts() {
        _selectedProducts.update { listOf() }
        updateTotalAmount()
    }

    fun removeProductFromSelected(product: Product) {
        val products = _selectedProducts.value.toMutableList()
        products.remove(product)
        _selectedProducts.update { products }
        updateTotalAmount()
    }

    fun updateTotalAmount() {
        _totalAmount.update { _selectedProducts.value.sumOf { it.price * it.quantity } }
    }

    fun updateSelectedProduct(products: List<Product>) {
        _selectedProducts.update { _ ->
            products
        }
    }

    private var _productsInCart = MutableStateFlow<List<Product>>(listOf(
        FoodProduct(
            name = "Đồ ăn cho chó cao cấp",
            description = "Đây là sản phẩm thức ăn cho chó cao cấp",
            price = 19000.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
            image = R.drawable.avt,
            detailDescription = "Chi tiết sản phẩm",
            id = "12",
        ),
        ToyProduct(
            name = "Đồ chơi cho chó",
            description = "Đây là sản phẩm đồ chơi cho chó",
            price = 50000.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
            image = R.drawable.avt,
            detailDescription = "Chi tiết sản phẩm",
            id = "13",
        ),
        ClothesProduct(
            name = "Quần áo cho chó",
            description = "Đây là sản phẩm quần áo cho chó",
            price = 100000.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
            image = R.drawable.avt,
            detailDescription = "Chi tiết sản phẩm",
            id = "14",
        )
    ))
    var productsInCart: StateFlow<List<Product>> = _productsInCart.asStateFlow()

    fun addProductToCart(product: Product) {
    val products = _productsInCart.value.toMutableList()
    products.add(0, product) // thêm sản phẩm vào đầu danh sách
    _productsInCart.update { products }
}

    fun removeProductFromCart(product: Product) {
        val products = _productsInCart.value.toMutableList()
        products.remove(product)
        _productsInCart.update { products }
    }

}
