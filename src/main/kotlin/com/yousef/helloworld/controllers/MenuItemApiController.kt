package com.yousef.helloworld.controllers

import com.yousef.helloworld.domain.dtos.menuitem.MenuCreateRequestDto
import com.yousef.helloworld.domain.dtos.menuitem.MenuItemDto
import com.yousef.helloworld.domain.entities.MenuItem
import com.yousef.helloworld.domain.toDto
import com.yousef.helloworld.domain.toEntity
import com.yousef.helloworld.services.MenuService
import com.yousef.helloworld.services.RestaurantService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/menus")
class MenuItemApiController(
    private val menuService: MenuService,
    private val restaurantService: RestaurantService
) {

    @GetMapping
    fun getMenuItems(): ResponseEntity<List<MenuItemDto>> {
        return ResponseEntity(menuService.all()
            .map { it.toDto() }, HttpStatus.OK)
    }

    @PostMapping
    fun createMenuItem(@RequestBody menuItemRequestDto: MenuCreateRequestDto)
        : ResponseEntity<MenuItem> {
        val restaurant = restaurantService.findById(menuItemRequestDto.restaurantId)
            ?: return ResponseEntity(HttpStatus.BAD_REQUEST)

        return ResponseEntity(
            menuService.create(
                menuItemRequestDto.toEntity(restaurant)
            ), HttpStatus.CREATED)
    }
}