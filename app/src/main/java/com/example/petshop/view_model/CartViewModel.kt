package com.example.petshop.view_model

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petshop.R
import com.example.petshop.database.controller.AccountController
import com.example.petshop.database.controller.CartController
import com.example.petshop.database.model.Account
import com.example.petshop.database.model.CartItem
import com.example.petshop.database.model.UserManager
import com.example.petshop.model.ClothesProduct
import com.example.petshop.model.FoodProduct
import com.example.petshop.model.Message
import com.example.petshop.model.Product
import com.example.petshop.model.Screen
import com.example.petshop.model.ToyProduct
import com.example.petshop.model.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class CartViewModel : ViewModel(
) {
    //------------------------------------------------------------------------------------------------
    var user_id: String? = null
    lateinit var database: DatabaseReference
    //------------------------------------------------------------------------------------------------
    private var _selectedProducts = MutableStateFlow<List<Product>>(listOf())
    var selectedProducts: StateFlow<List<Product>> = _selectedProducts.asStateFlow()

    private var _totalAmount = MutableStateFlow(0.0)
    var totalAmount: StateFlow<Double> = _totalAmount.asStateFlow()

    //========================= Sửa cái đoạn này thì nó hiển thị được ra màn hình giỏ hàng
    // vấn đề là biến product nó nhiều thuộc tính quá
    // chạy đoạn này là sẽ bị tắt app
    // anh nghĩ là do biến image
    // em vào firebase, trong carts nó lưu image là dạng số, anh qua data mẫu của em thì thấy để R.draw.id_sp
    // em thử chỉnh xem

    fun getProductsByUserId(){
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val productList = mutableListOf<Product>()
                for (productSnapshot in dataSnapshot.children) {
                    val product = Product.fromSnapshot(productSnapshot)
                    product?.let {
                        productList.add(it)
                    }
                }
                        _productsInCart.update { productList }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
//------------------------------------------------------------------------------------------------
    fun addProductToSelected(product: Product) {
        val products = _selectedProducts.value.toMutableList()
        products.add(product)
        _selectedProducts.update { products }
        updateTotalAmount()
    }

    fun up_set_UserId(id: String) {
        this.user_id = id
        this.database = FirebaseDatabase.getInstance().reference.child("Carts").child(id)
    }



//    fun resetSelectedProducts() {
//        _selectedProducts.update { listOf() }
//        updateTotalAmount()
//    }

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

        database.child(product.id).setValue(product)
    }

    fun removeProductFromCart(product: Product) {
        val products = _productsInCart.value.toMutableList()
        products.remove(product)
        _productsInCart.update { products }
    }
}
