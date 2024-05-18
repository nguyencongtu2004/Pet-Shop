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
    private val _currentOrder = MutableStateFlow<Order>(Order())
    val currentOrder: StateFlow<Order> = _currentOrder.asStateFlow()

    init {
        calculateProductTotal()
    }

    private fun calculateProductTotal() {
        _currentOrder.update { order ->
            val productTotal = order.products.sumOf { it.price * it.quantity }

            order.copy(
                productTotal = productTotal,
                total = productTotal + order.shippingFee
            )
        }
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
        _currentOrder.update { _ ->
            newOrder
        }
        calculateProductTotal()  // Recalculate total when a new order is set
    }

    fun addProduct(product: Product) {
        _currentOrder.update { order ->
            val updatedProducts = order.products.toMutableList().apply { add(product) }
            order.copy(products = updatedProducts)
        }
        calculateProductTotal()  // Recalculate total when a product is added
    }

    fun updateProduct(index: Int, product: Product) {
        _currentOrder.update { order ->
            val updatedProducts = order.products.toMutableList().apply { this[index] = product }
            order.copy(products = updatedProducts)
        }
        calculateProductTotal()  // Recalculate total when a product is updated
    }

    fun resetOrder() {
        _currentOrder.update { _ ->
            Order()
        }
    }


    private val _allOrders = MutableStateFlow<List<Order>>(listOf())
    val allOrders: StateFlow<List<Order>> = _allOrders.asStateFlow()

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
