package ir.sina.mrcshop.service

import ir.sina.mrcshop.entity.Category
import ir.sina.mrcshop.repository.CategoryRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository
) : CategoryService {

    override fun createCategory(category: Category): Category {
        return categoryRepository.save(category)
    }

    override fun getCategoryById(id: String): Category {
        return categoryRepository.findById(id)
            .orElseThrow { NoSuchElementException("Category not found with id: $id") }
    }

    override fun getAllCategories(): List<Category> {
        return categoryRepository.findAll()
    }

    override fun updateCategory(id: String, category: Category): Category {
        val existingCategory = getCategoryById(id)
        val updatedCategory = existingCategory.copy(
            name = category.name,
            description = category.description
        )
        return categoryRepository.save(updatedCategory)
    }

    override fun deleteCategory(id: String) {
        val category = getCategoryById(id)
        categoryRepository.delete(category)
    }
}
