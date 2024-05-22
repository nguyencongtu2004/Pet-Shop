package com.example.petshop.database.controller

import com.example.petshop.database.model.Cart
import com.example.petshop.database.model.CartItem
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CartController {
    companion object {

        //        private val database: DatabaseReference = FirebaseDatabase.getInstance().reference
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Carts")
        fun addCartItem(
            userId: String,
            newCartItem: CartItem,
            callback: (Boolean, String) -> Unit
        ) {

            // Truy xuất giỏ hàng của người dùng từ Firebase
            myRef.child(userId.toString()).get().addOnSuccessListener { dataSnapshot ->
                var cart = dataSnapshot.getValue(Cart::class.java)

                if (cart == null) {
                    // Trường hợp 1: Giỏ hàng chưa có sản phẩm nào
                    cart = Cart(id_user = userId, items = mutableListOf(newCartItem))
                } else {
                    // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng hay chưa
                    val existingCartItem =
                        cart.items.find { it.id_product == newCartItem.id_product }

                    if (existingCartItem != null) {
                        // Trường hợp 2: Thêm cùng 1 ID sản phẩm thì tăng số lượng
                        existingCartItem.quantity += newCartItem.quantity
                    } else {
                        // Trường hợp 3: Thêm sản phẩm khác ID thì thêm vào giỏ hàng sản phẩm đó
                        cart.items.add(newCartItem)
                    }
                }

                // Lưu lại giỏ hàng vào Firebase
                myRef.child(userId.toString()).setValue(cart)
                    .addOnSuccessListener {
                        callback(true, "Sản phẩm đã được thêm vào giỏ hàng")
                    }
                    .addOnFailureListener { e ->
                        callback(false, "Lỗi khi thêm sản phẩm vào giỏ hàng: ${e.message}")
                    }
            }.addOnFailureListener { e ->
                callback(false, "Lỗi khi truy xuất giỏ hàng: ${e.message}")
            }
        }
    }}