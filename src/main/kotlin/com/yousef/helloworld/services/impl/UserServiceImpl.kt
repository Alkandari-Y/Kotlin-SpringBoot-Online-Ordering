package com.yousef.helloworld.services.impl

import com.yousef.helloworld.domain.entities.User
import com.yousef.helloworld.respositories.UserRepository
import com.yousef.helloworld.services.UserService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository): UserService {
    override fun all(): Iterable<User> {
        return userRepository.findAll()
    }

    override fun createUser(user: User): User {
        check(user.id == null)
        return userRepository.save(user)
    }

    override fun findById(id: Long): User? {
        return userRepository.findByIdOrNull(id)
    }

    override fun findByUsername(name: String): User? {
        return userRepository.findByUsername(name)
    }
}