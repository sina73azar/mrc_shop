package ir.sina.mrcshop.controller

import ir.sina.mrcshop.entity.Product
import ir.sina.mrcshop.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping
    fun createProduct(@RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity(productService.createProduct(product), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: String): ResponseEntity<Product> {
        return ResponseEntity.ok(productService.getProductById(id))
    }

    @GetMapping
    fun getAllProducts(): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(productService.getAllProducts())
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: String, @RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity.ok(productService.updateProduct(id, product))
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: String): ResponseEntity<Void> {
        productService.deleteProduct(id)
        return ResponseEntity.noContent().build()
    }
}
