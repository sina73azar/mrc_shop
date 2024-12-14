package ir.sina.mrcshop.entity

import jakarta.persistence.*

@Entity
@Table(name = "products")
data class Product(
    @Column(nullable = false, unique = true)
    val title: String,

    val description: String? = null,

    @Column(nullable = false)
    val price: Double,

    @Column(nullable = true)
    val technicalSpecification: String? = null,

    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = [JoinColumn(name = "product_id")])
    @Column(
        name = "image_url", nullable =
            true
    )
    val images: List<String> = listOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    val category: Category,

    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL], orphanRemoval = true)
    val orderProducts: MutableList<OrderProduct> = mutableListOf()
) : BaseEntity()
