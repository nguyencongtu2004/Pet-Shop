package com.example.petshop.database.model

data class Product(
    var product_id: String? = null,
    var p_name: String? = null,
    var p_price: Int? = null,
    var p_rate: Float? = null,
    var p_type: String? = null,
    var p_info: String? = null,
    var p_tags: List<String>? = null,
)