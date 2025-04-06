package com.yousef.helloworld.services

import com.yousef.helloworld.domain.entities.Restaurant
import com.yousef.helloworld.respositories.RestaurantRepository
import org.springframework.stereotype.Service

@Service
class RestaurantServiceImpl(
    private val restaurantRepository: RestaurantRepository
): RestaurantService {
    override fun create(restaurant: Restaurant): Restaurant {
        TODO("Not yet implemented")
    }

    override fun all(): List<Restaurant> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Restaurant? {
        TODO("Not yet implemented")
    }

    override fun findByName(name: String): Restaurant? {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(restaurant: Restaurant) {
        TODO("Not yet implemented")
    }
}