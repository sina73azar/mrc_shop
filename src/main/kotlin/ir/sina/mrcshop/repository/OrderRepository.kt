package ir.sina.mrcshop.repository

import ir.sina.mrcshop.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, String> {
    fun findByOrderNumber(orderNumber: String): Order?
}