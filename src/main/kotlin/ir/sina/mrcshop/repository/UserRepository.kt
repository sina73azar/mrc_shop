package ir.sina.mrcshop.repository

import ir.sina.mrcshop.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<User, String> {
    fun findByFullName(fullName: String): Optional<User>
}
