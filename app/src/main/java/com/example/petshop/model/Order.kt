package com.example.petshop.model

enum class OrderStatus {
    PREPARE,
    SHIPPING,
    DELIVERED,
}

enum class DeliveryMethod {
    NORMAL,
    FAST,
}

enum class PaymentMethod {
    CASH,
    BANK,
}

data class Order(
    var user: User = User(),
    var products: List<Product> = listOf(),

    var deliveryMethod: DeliveryMethod = DeliveryMethod.NORMAL,
    var paymentMethod: PaymentMethod = PaymentMethod.CASH,
    var voucher: Voucher = Voucher(),

    var productTotal: Double = 0.0,
    var shippingFee: Double = 12000.0,
    var total: Double = 0.0,

    var status: OrderStatus = OrderStatus.PREPARE
)