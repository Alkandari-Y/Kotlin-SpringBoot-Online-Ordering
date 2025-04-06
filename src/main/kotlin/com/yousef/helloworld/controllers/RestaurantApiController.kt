package com.yousef.helloworld.contorllers

import com.yousef.helloworld.domain.dtos.restaurant.RestaurantCreateRequestDto
import com.yousef.helloworld.domain.dtos.restaurant.RestaurantDetailDto
import com.yousef.helloworld.domain.dtos.restaurant.RestaurantDto
import com.yousef.helloworld.domain.toDetailDto
import com.yousef.helloworld.domain.toDto
import com.yousef.helloworld.domain.toEntity
import com.yousef.helloworld.services.RestaurantService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/restaurants")
class RestaurantApiController(
    private val restaurantService: RestaurantService
) {

    @GetMapping
    fun getAllRestaurants(): ResponseEntity<List<RestaurantDto>> =
        ResponseEntity(restaurantService.all()
            .map { it.toDto() }, HttpStatus.OK)

    @PostMapping
    fun createNewRestaurant(@RequestBody restaurantCreateDto: RestaurantCreateRequestDto)
    : ResponseEntity<RestaurantDto> {
        return try {
            val createdUser = restaurantService.create(restaurantCreateDto.toEntity()).toDto()
            ResponseEntity(createdUser, HttpStatus.CREATED)
        } catch (e: IllegalStateException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping(path=["/{id}"])
    fun getRestaurantById(@PathVariable id: Long): ResponseEntity<RestaurantDetailDto> {
        val restaurant = restaurantService.findById(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(restaurant.toDetailDto(), HttpStatus.OK)
    }
}