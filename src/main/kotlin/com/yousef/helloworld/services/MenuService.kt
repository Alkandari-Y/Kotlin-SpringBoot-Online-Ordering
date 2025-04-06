package com.yousef.helloworld.services

import com.yousef.helloworld.domain.entities.MenuItem


interface MenuService {
    fun all(): List<MenuItem>
    fun findById(id: Long): MenuItem?
    fun byRestaurantId(restaurantId: Long): List<MenuItem?>?
    fun byRestaurantName(restaurantName: String): List<MenuItem?>?
    fun create(menuItem: MenuItem): MenuItem
    fun update(menuItem: MenuItem): MenuItem
    fun delete(id: Long): Unit
}