package ir.sina.mrcshop.exception

import java.time.LocalDateTime

data class ValidationErrorResponse(
    val timestamp: LocalDateTime,
    val status: Int,
    val errors: List<FieldError>
)

data class FieldError(
    val field: String,
    val message: String
)
