package ir.sina.mrcshop.entity

import ir.sina.mrcshop.enums.Gender
import ir.sina.mrcshop.enums.Role
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

@Entity
@Table(name = "users")
data class User(
    val firstName: String,
    val lastName: String,
    @field:NotBlank(message = "Full name is required")
    val fullName: String,
    val age: Int,
    @Enumerated(EnumType.STRING)
    val gender: Gender,
    @Enumerated(EnumType.STRING)
    @field:NotNull(message = "Role is required")
    val role: Role,
    val address: String?,
    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "contact_info_id", referencedColumnName = "id")
    val contactInfo: ContactInfo? = null,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val orders: MutableList<Order> = mutableListOf()

) : BaseEntity()
