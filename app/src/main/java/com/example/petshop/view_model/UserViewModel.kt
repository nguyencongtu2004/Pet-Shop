package com.example.petshop.view_model

import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import com.example.petshop.R
import com.example.petshop.model.User

class UserViewModel : ViewModel() {
    var currentUser = User(
        name = "Nguyễn Công Tú",
        role = "Khách hàng thân thiết",
        favoriteProducts = listOf(),
        sex = "Nam",
        email = "asdfsaf@asadfs.fff",
        phone = "0123456789",
        avatar = R.drawable.avatar,
        birthday = "01/01/2000",
        password = "null",
        address = "đâu đó",
    )
        private set

    fun updateUserInfo(user: User) {
        currentUser = user
    }

}