package com.yousef.helloworld.domain.dtos.restaurant

import com.yousef.helloworld.domain.dtos.menuitem.MenuItemSummaryDto


data class RestaurantDetailDto(
    val id: Long,
    val name: String,
    val logo: String,
    val menuItems: List<MenuItemSummaryDto>
)
