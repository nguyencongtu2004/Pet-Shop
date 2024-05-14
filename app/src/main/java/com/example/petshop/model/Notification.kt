package com.example.petshop.model

import androidx.compose.ui.graphics.painter.Painter

data class Notification(
    var title: String = "",
    var description: String = "",
    var image: Painter? = null,
)