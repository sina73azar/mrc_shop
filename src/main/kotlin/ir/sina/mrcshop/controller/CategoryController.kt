package ir.sina.mrcshop.controller

import ir.sina.mrcshop.entity.Category
import ir.sina.mrcshop.service.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categories")
class CategoryController(
    private val categoryService: CategoryService
) {

    @PostMapping
    fun createCategory(@RequestBody category: Category): ResponseEntity<Category> {
        return ResponseEntity(categoryService.createCategory(category), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: String): ResponseEntity<Category> {
        return ResponseEntity.ok(categoryService.getCategoryById(id))
    }

    @GetMapping
    fun getAllCategories(): ResponseEntity<List<Category>> {
        return ResponseEntity.ok(categoryService.getAllCategories())
    }

    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: String, @RequestBody category: Category): ResponseEntity<Category> {
        return ResponseEntity.ok(categoryService.updateCategory(id, category))
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: String): ResponseEntity<Void> {
        categoryService.deleteCategory(id)
        return ResponseEntity.noContent().build()
    }
}
