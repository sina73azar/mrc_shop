package ir.sina.mrcshop.service

import ir.sina.mrcshop.entity.User

interface UserService {
    fun createUser(user: User): User
    fun getUserById(id: String): User
    fun getAllUsers(): List<User>
    fun updateUser(id: String, user: User): User
    fun deleteUser(id: String)
    fun findUserByFullName(fullName: String): User
}
