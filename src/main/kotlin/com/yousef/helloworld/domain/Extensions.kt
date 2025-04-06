package com.yousef.helloworld.domain

import com.yousef.helloworld.domain.dtos.users.UserDto
import com.yousef.helloworld.domain.dtos.menuitem.MenuCreateRequestDto
import com.yousef.helloworld.domain.dtos.menuitem.MenuItemDto
import com.yousef.helloworld.domain.dtos.menuitem.MenuItemSummaryDto
import com.yousef.helloworld.domain.dtos.restaurant.RestaurantCreateRequestDto
import com.yousef.helloworld.domain.dtos.restaurant.RestaurantDetailDto
import com.yousef.helloworld.domain.dtos.restaurant.RestaurantDto
import com.yousef.helloworld.domain.dtos.users.UserCreateRequestDto
import com.yousef.helloworld.domain.entities.MenuItem
import com.yousef.helloworld.domain.entities.Restaurant
import com.yousef.helloworld.domain.entities.User

fun RestaurantCreateRequestDto.toEntity() = Restaurant(
    id=null,
    name=this.name,
    logo=this.logo
)

fun Restaurant.toDto(): RestaurantDto {
    checkNotNull(this.id) { "Cannot convert a restaurant entity with a null id to a Dto" }
    return RestaurantDto(
        id=this.id,
        name=this.name,
        logo=this.logo
    )
}

fun Restaurant.toDetailDto(): RestaurantDetailDto {
    checkNotNull(this.id) { "Cannot convert a restaurant entity with a null id to a Dto" }
    return RestaurantDetailDto(
        id=this.id,
        name=this.name,
        logo=this.logo,
        menuItems = this.menuItems.map { it.toSummaryDto() }
    )
}

fun MenuItem.toSummaryDto() = MenuItemSummaryDto(
    id=this.id!!,
    name=this.name,
    price=this.price,
    image=this.image
)

fun MenuItem.toDto() = MenuItemDto(
    id=this.id!!,
    name=this.name,
    price=this.price,
    image=this.image,
    restaurantId=this.restaurant!!.id!!
)

fun UserCreateRequestDto.toEntity() = User(
    username=this.username,
    name=this.name
)

fun User.toDto() = UserDto(
    id=this.id!!,
    username=this.username,
    name=this.name
)

fun MenuCreateRequestDto.toEntity(restaurant: Restaurant) = MenuItem(
    name=this.name,
    price=this.price,
    image=this.image,
    restaurant=restaurant
)

