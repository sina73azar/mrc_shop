package ir.sina.mrcshop.service

import ir.sina.mrcshop.entity.Product

interface ProductService {
    fun createProduct(product: Product): Product
    fun getProductById(id: String): Product
    fun getAllProducts(): List<Product>
    fun updateProduct(id: String, product: Product): Product
    fun deleteProduct(id: String)
}
