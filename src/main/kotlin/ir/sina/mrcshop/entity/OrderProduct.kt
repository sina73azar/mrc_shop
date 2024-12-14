package ir.sina.mrcshop.entity

import jakarta.persistence.*

@Entity
@Table(name = "order_products")
data class OrderProduct(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    val order: Order,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    val product: Product,

    @Column(nullable = false)
    val quantity: Int = 1,

    @Column(nullable = false)
    val price: Double = 0.0
) : BaseEntity()
