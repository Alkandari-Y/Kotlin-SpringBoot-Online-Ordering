package com.yousef.helloworld.domain.dtos.menuitem

data class MenuCreateRequestDto(
    val name: String,
    val price: Double,
    val restaurantId: Long,
    val image: String
)
