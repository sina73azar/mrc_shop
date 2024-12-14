package ir.sina.mrcshop.repository

import ir.sina.mrcshop.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, String> {
    fun findByTitle(title: String): List<Product>
}
