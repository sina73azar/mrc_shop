package ir.sina.mrcshop.repository

import ir.sina.mrcshop.entity.OrderProduct
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderProductRepository : JpaRepository<OrderProduct, String>
