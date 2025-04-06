package com.yousef.helloworld.services

import com.yousef.helloworld.domain.entities.Restaurant


interface RestaurantService {
    fun create(restaurant: Restaurant): Restaurant
    fun all(): Iterable<Restaurant>
    fun findById(id: Long): Restaurant?
    fun findByName(name: String): Restaurant?
    fun deleteById(id: Long): Unit
    fun update(id: Long, restaurant: Restaurant): Restaurant
}