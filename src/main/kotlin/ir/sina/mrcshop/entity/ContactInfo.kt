package ir.sina.mrcshop.entity

import jakarta.persistence.*

@Entity
@Table(name = "contact_infos")
data class ContactInfo(
    val phone: String? = null,
    val email: String? = null,
    val fax: String? = null,
    val recoveryEmail: String? = null
) : BaseEntity()