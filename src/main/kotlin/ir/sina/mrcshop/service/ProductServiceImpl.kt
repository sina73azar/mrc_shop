package ir.sina.mrcshop.service

import ir.sina.mrcshop.entity.Product
import ir.sina.mrcshop.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
) : ProductService {

    override fun createProduct(product: Product): Product {
        return productRepository.save(product)
    }

    override fun getProductById(id: String): Product {
        return productRepository.findById(id)
            .orElseThrow { NoSuchElementException("Product not found with id: $id") }
    }

    override fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }

    override fun updateProduct(id: String, product: Product): Product {
        val existingProduct = getProductById(id)
        val updatedProduct = existingProduct.copy(
            title = product.title,
            description = product.description,
            price = product.price,
            technicalSpecification = product.technicalSpecification,
            images = product.images,
            category = product.category
        )
        return productRepository.save(updatedProduct)
    }

    override fun deleteProduct(id: String) {
        val product = getProductById(id)
        productRepository.delete(product)
    }
}
