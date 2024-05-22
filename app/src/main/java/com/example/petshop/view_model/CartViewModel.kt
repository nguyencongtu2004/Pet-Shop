package com.example.petshop.view_model

import androidx.lifecycle.ViewModel
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

    private var _productsInCart = MutableStateFlow<List<Product>>(listOf())
    var productsInCart: StateFlow<List<Product>> = _productsInCart.asStateFlow()

    fun addProductToCart(
        product: Product
    ) {
        val products = _productsInCart.value.toMutableList()
        val existingProductIndex = products.indexOfFirst {
            it.id == product.id && (
                    (it is FoodProduct && product is FoodProduct &&
                            it.selectedFlavor == product.selectedFlavor &&
                            it.selectedWeight == product.selectedWeight) ||
                            (it is ToyProduct && product is ToyProduct &&
                                    it.selectedSize == product.selectedSize) ||
                            (it is ClothesProduct && product is ClothesProduct &&
                                    it.selectedSize == product.selectedSize)
                    )
        }

        if (existingProductIndex != -1) {
            // Nếu sản phẩm đã tồn tại, tăng số lượng
            val existingProduct = products[existingProductIndex]
            products[existingProductIndex] = when (existingProduct) {
                is FoodProduct -> existingProduct.copy(quantity = existingProduct.quantity + product.quantity)
                is ToyProduct -> existingProduct.copy(quantity = existingProduct.quantity + product.quantity)
                is ClothesProduct -> existingProduct.copy(quantity = existingProduct.quantity + product.quantity)
            }
        } else {
            // Nếu sản phẩm chưa tồn tại, thêm mới vào danh sách
            products.add(0, product)
        }

        _productsInCart.update { products }
    }


    fun removeProductFromCart(product: Product) {
        val products = _productsInCart.value.toMutableList()
        products.remove(product)
        _productsInCart.update { products }
    }

}
