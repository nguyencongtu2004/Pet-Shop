package com.example.petshop.view_model

import androidx.lifecycle.ViewModel
import com.example.petshop.R

class BannerViewModel : ViewModel() {
    var allBanners: List<Int> = listOf(
        R.drawable.banner,
        R.drawable.logo,
        R.drawable.avatar,
        R.drawable.default_noti,
        R.drawable.avt,
    )
        private set
}