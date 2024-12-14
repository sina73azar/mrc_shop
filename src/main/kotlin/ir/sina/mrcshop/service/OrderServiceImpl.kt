package ir.sina.mrcshop.service

import ir.sina.mrcshop.entity.Order
import ir.sina.mrcshop.repository.OrderRepository
import ir.sina.mrcshop.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val productRepository: ProductRepository
) : OrderService {

    override fun createOrder(order: Order): Order {
        // Calculate total price from order products
        val totalPrice = order.orderProducts.sumOf {
            val product = productRepository.findById(it.product.id!!)
                .orElseThrow { NoSuchElementException("Product not found with id: ${it.product.id}") }
            it.copy(price = product.price * it.quantity).price
        }

        // Save the order (cascading will save order products)
        val newOrder = order.copy(totalPrice = totalPrice)
        return orderRepository.save(newOrder)
    }

    override fun getOrderById(id: String): Order {
        return orderRepository.findById(id)
            .orElseThrow { NoSuchElementException("Order not found with id: $id") }
    }

    override fun getAllOrders(): List<Order> {
        return orderRepository.findAll()
    }

    override fun updateOrder(id: String, order: Order): Order {
        val existingOrder = getOrderById(id)

        // Update order and products (cascading will handle updates)
        val updatedOrder = existingOrder.copy(
            status = order.status,
            orderProducts = order.orderProducts,
            totalPrice = order.orderProducts.sumOf {
                val product = productRepository.findById(it.product.id!!)
                    .orElseThrow { NoSuchElementException("Product not found with id: ${it.product.id}") }
                product.price * it.quantity
            }
        )
        return orderRepository.save(updatedOrder)
    }

    override fun deleteOrder(id: String) {
        val order = getOrderById(id)
        orderRepository.delete(order)
    }
}
