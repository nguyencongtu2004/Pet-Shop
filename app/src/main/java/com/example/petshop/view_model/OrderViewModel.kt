package com.example.petshop.view_model

import androidx.lifecycle.ViewModel
import com.example.petshop.model.DeliveryMethod
import com.example.petshop.model.Order
import com.example.petshop.model.OrderStatus
import com.example.petshop.model.PaymentMethod
import com.example.petshop.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {
    private val _order = MutableStateFlow<Order>(Order())
    val order: StateFlow<Order> = _order.asStateFlow()

    init {
        calculateProductTotal()
    }

    private fun calculateProductTotal() {
        _order.update { order ->
            val productTotal = order.products.sumOf { it.price * it.quantity }
            order.copy(
                productTotal = productTotal,
                total = productTotal + order.shippingFee
            )
        }
    }

    fun updateOrderStatus(status: OrderStatus) {
        _order.update { order ->
            order.copy(status = status)
        }
    }

    fun updateOrderDeliveryMethod(deliveryMethod: DeliveryMethod) {
        _order.update { order ->
            order.copy(deliveryMethod = deliveryMethod)
        }
        println("Delivery method: $deliveryMethod")
    }

    fun updateOrderPaymentMethod(paymentMethod: PaymentMethod) {
        _order.update { order ->
            order.copy(paymentMethod = paymentMethod)
        }
        println("Payment method: $paymentMethod")
    }

    fun updateOrder(newOrder: Order) {
        _order.update { _ ->
            newOrder
        }
        calculateProductTotal()  // Recalculate total when a new order is set
    }

    fun addProduct(product: Product) {
        _order.update { order ->
            val updatedProducts = order.products.toMutableList().apply { add(product) }
            order.copy(products = updatedProducts)
        }
        calculateProductTotal()  // Recalculate total when a product is added
    }

    fun updateProduct(index: Int, product: Product) {
        _order.update { order ->
            val updatedProducts = order.products.toMutableList().apply { this[index] = product }
            order.copy(products = updatedProducts)
        }
        calculateProductTotal()  // Recalculate total when a product is updated
    }

    fun resetOrder() {
        _order.update { _ ->
            Order()
        }
    }
}
