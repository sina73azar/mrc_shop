package ir.sina.mrcshop.service

import ir.sina.mrcshop.entity.Category

interface CategoryService {
    fun createCategory(category: Category): Category
    fun getCategoryById(id: String): Category
    fun getAllCategories(): List<Category>
    fun updateCategory(id: String, category: Category): Category
    fun deleteCategory(id: String)
}
