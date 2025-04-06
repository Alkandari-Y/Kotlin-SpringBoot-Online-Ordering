package com.yousef.helloworld.respositories

import com.yousef.helloworld.domain.entities.MenuItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface MenuRepository: JpaRepository<MenuItem, Long?> {
    fun findByRestaurantId(restaurantId: Long?): List<MenuItem?>?
    fun findByRestaurantName(name: String): List<MenuItem?>?
}