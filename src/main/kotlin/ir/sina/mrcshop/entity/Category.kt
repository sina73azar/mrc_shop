package ir.sina.mrcshop.entity

import jakarta.persistence.*

@Entity
@Table(name = "categories")
data class Category(
    @Column(nullable = false, unique = true)
    val name: String,

    val description: String? = null,

    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], orphanRemoval = true)
    val products: MutableList<Product> = mutableListOf()
) : BaseEntity()
