package ir.sina.mrcshop.service

import ir.sina.mrcshop.entity.Order

interface OrderService {
    fun createOrder(order: Order): Order
    fun getOrderById(id: String): Order
    fun getAllOrders(): List<Order>
    fun updateOrder(id: String, order: Order): Order
    fun deleteOrder(id: String)
}
