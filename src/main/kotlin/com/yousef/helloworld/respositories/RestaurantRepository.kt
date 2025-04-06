package com.yousef.helloworld.respositories

import com.yousef.helloworld.domain.entities.Restaurant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RestaurantRepository : JpaRepository<Restaurant, Long?> {
    fun findByName(name: String): Restaurant?
    fun existsByName(name: String): Boolean
}