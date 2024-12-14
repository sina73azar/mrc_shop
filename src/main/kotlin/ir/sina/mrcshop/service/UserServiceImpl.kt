package ir.sina.mrcshop.service

import ir.sina.mrcshop.entity.User
import ir.sina.mrcshop.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun createUser(user: User): User {
        return userRepository.save(user)
    }

    override fun getUserById(id: String): User {
        return userRepository.findById(id)
            .orElseThrow { NoSuchElementException("User not found with id: $id") }
    }

    override fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    override fun updateUser(id: String, user: User): User {
        val existingUser = getUserById(id)
        val updatedUser = existingUser.copy(
            firstName = user.firstName,
            lastName = user.lastName,
            fullName = user.fullName,
            age = user.age,
            gender = user.gender,
            role = user.role,
            address = user.address,
            contactInfo = user.contactInfo
        )
        return userRepository.save(updatedUser)
    }

    override fun deleteUser(id: String) {
        val user = getUserById(id)
        userRepository.delete(user)
    }

    override fun findUserByFullName(fullName: String): User {
        return userRepository.findByFullName(fullName)
            .orElseThrow { NoSuchElementException("User not found with fullName: $fullName") }
    }
}
