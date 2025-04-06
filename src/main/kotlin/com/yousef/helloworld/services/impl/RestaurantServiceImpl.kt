package com.yousef.helloworld.services.impl

import com.yousef.helloworld.domain.entities.Restaurant
import com.yousef.helloworld.respositories.RestaurantRepository
import com.yousef.helloworld.services.RestaurantService
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class RestaurantServiceImpl(
    private val restaurantRepository: RestaurantRepository,
): RestaurantService {

    override fun create(restaurant: Restaurant): Restaurant {
        check(restaurant.id == null)
        check(restaurantRepository.findByName(restaurant.name) == null) {"Restaurant name already exists"}
        return restaurantRepository.save(restaurant)
    }

    override fun all(): List<Restaurant> {
        return restaurantRepository.findAll()
    }

    override fun findById(id: Long): Restaurant? {
        return restaurantRepository.findByIdOrNull(id)
    }

    override fun findByName(name: String): Restaurant? {
        return restaurantRepository.findByName(name)
    }

    override fun deleteById(id: Long): Unit {
        restaurantRepository.deleteById(id)
    }

    @Transactional
    override fun update(id: Long, restaurant: Restaurant): Restaurant {
        check(restaurantRepository.existsById(id))
        val normalizedRestaurant = restaurant.copy(id=id)
        return restaurantRepository.save(normalizedRestaurant)
    }
}