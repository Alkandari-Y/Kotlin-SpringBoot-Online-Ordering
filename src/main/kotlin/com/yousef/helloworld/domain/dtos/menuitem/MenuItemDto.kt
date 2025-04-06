package com.yousef.helloworld.domain.dtos.menuitem

data class MenuItemDto(
    val id: Long,
    val name: String,
    val price: Double,
    val restaurantId: Long,
    val image: String
)
