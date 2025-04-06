package com.yousef.helloworld.services

import com.yousef.helloworld.domain.entities.User
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun all(): Iterable<User>
    fun createUser(user: User): User
    fun findById(id: Long): User?
    fun findByUsername(name: String): User?
}