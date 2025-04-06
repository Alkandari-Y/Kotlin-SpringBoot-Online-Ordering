package com.yousef.helloworld.respositories

import com.yousef.helloworld.domain.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long?> {
    fun findByUsername(name: String): User?
}