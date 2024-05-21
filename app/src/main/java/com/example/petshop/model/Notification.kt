package com.example.petshop.model

import androidx.compose.ui.graphics.painter.Painter
import com.example.petshop.R

data class Notification(
    var title: String = "",
    var description: String = "",
    var image: Int = R.drawable.noti_icon,
    var isSeen: Boolean = false,
)