package com.example.petshop.model

import androidx.compose.ui.graphics.painter.Painter

data class User(
    var avatar: Painter? = null,
    var name: String = "Nguyễn Văn A",
    var role: String = "Thành viên",
    var sex: String = "Nam",
    var birthday: String = "01/01/2000",
    var address: String = "đâu đó",

    var phone: String = "0123456789",
    var email: String = "noemail@email.com",
    var password: String? = null, // Chưa đăng nhập thì password = null

    var favoriteProducts: List<Product> = listOf(),
)