package ir.sina.mrcshop.entity

import ir.sina.mrcshop.enums.OrderStatus
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
data class Order(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: User,

    @Column(nullable = false, unique = true)
    val orderNumber: String,

    @Enumerated(EnumType.STRING)
    val status: OrderStatus = OrderStatus.PENDING,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    val orderProducts: MutableList<OrderProduct> = mutableListOf(),

    @Column(nullable = false)
    val totalPrice: Double = 0.0,

    val orderedAt: LocalDateTime = LocalDateTime.now()
) : BaseEntity()