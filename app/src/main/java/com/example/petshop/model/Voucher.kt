package com.example.petshop.model

data class Voucher(
    var code: String = "",

    var title: String = "",
    var description: String = "",

    var isDiscountByPercent: Boolean = true,
    var discount: Double = 0.0,
    var discountPercent: Double = 0.0,
    var discountMax: Double = 0.0,
    var minOrderValue: Double = 0.0,
)