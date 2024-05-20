package com.example.petshop.view_model

import androidx.lifecycle.ViewModel
import com.example.petshop.R
import com.example.petshop.model.DeliveryMethod
import com.example.petshop.model.Order
import com.example.petshop.model.OrderStatus
import com.example.petshop.model.PaymentMethod
import com.example.petshop.model.Product
import com.example.petshop.model.Voucher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {
    private val _currentOrder = MutableStateFlow(Order())
    val currentOrder: StateFlow<Order> = _currentOrder.asStateFlow()

    private val _allOrders = MutableStateFlow<List<Order>>(listOf())
    val allOrders: StateFlow<List<Order>> = _allOrders.asStateFlow()

    private var _allVouchers = MutableStateFlow<List<Voucher>>(listOf(
        Voucher(
            title = "Giảm 10% tối đa 20.000 đ",
            description = "Không yêu cầu giá trị đơn hàng",
            image = R.drawable.voucher,
            isDiscountByPercent = true,
            discountPercent = 10.0,
            minOrderValue = 0.0,
            discountMax = 20000.0,
        ),
        Voucher(
            title = "Giảm 15% tối đa 35.000 đ",
            description = "Đơn tối thiểu 20.000 đ",
            image = R.drawable.voucher,
            isDiscountByPercent = true,
            discountPercent = 15.0,
            minOrderValue = 20000.0,
            discountMax = 35000.0,
        ),
        Voucher(
            title = "Giảm 75.000 đ",
            description = "Đơn tối thiểu 280.000 đ",
            image = R.drawable.bca,
            isDiscountByPercent = false,
            discount = 75000.0,
            minOrderValue = 280000.0,
        )
    ))
    val allVouchers: StateFlow<List<Voucher>> = _allVouchers.asStateFlow()

    init {
        // Ensure correct initial calculation
        updateOrder(_currentOrder.value)
    }

    private fun calculateProductTotal(order: Order): Order {
        val productTotal = order.products.sumOf { it.price * it.quantity }
        return order.copy(
            productTotal = productTotal,
            total = productTotal + order.shippingFee - order.discount
        )
    }

    private fun calculateDiscount(order: Order): Order {
        val discount = order.voucher?.let { voucher ->
            if (order.productTotal >= voucher.minOrderValue) {
                if (voucher.isDiscountByPercent) {
                    val discount = order.productTotal * voucher.discountPercent / 100
                    if (discount > voucher.discountMax) voucher.discountMax else discount
                } else {
                    voucher.discount
                }
            } else {
                0.0
            }
        } ?: 0.0

        return order.copy(discount = discount)
    }


    fun updateVoucher(voucher: Voucher) {
        _currentOrder.update { order ->
            var updatedOrder = order.copy(voucher = voucher)

            updatedOrder = calculateDiscount(updatedOrder)
            updatedOrder = calculateProductTotal(updatedOrder)
            updatedOrder
        }
        println("Discount after: ${_currentOrder.value.discount}")
    }


    fun updateOrderStatus(status: OrderStatus) {
        _currentOrder.update { order ->
            order.copy(status = status)
        }
    }

    fun updateOrderDeliveryMethod(deliveryMethod: DeliveryMethod) {
        _currentOrder.update { order ->
            order.copy(deliveryMethod = deliveryMethod)
        }
        println("Delivery method: $deliveryMethod")
    }

    fun updateOrderPaymentMethod(paymentMethod: PaymentMethod) {
        _currentOrder.update { order ->
            order.copy(paymentMethod = paymentMethod)
        }
        println("Payment method: $paymentMethod")
    }

    fun updateOrder(newOrder: Order) {
        var updatedOrder = newOrder
        updatedOrder = calculateProductTotal(updatedOrder)
        //updatedOrder = calculateDiscount(updatedOrder)
        _currentOrder.value = updatedOrder
    }

    fun resetOrder() {
        _currentOrder.update { Order() }
    }

    fun addOrder(order: Order) {
        _allOrders.update { orders ->
            orders.toMutableList().apply { add(order) }
        }

        _allOrders.value.forEach {
            println("Order ID: ${it.id}")
            println("Products count: ${it.products.size}")
            println("Shipping status: ${it.status}")
        }
    }
}
