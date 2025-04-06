package com.yousef.helloworld.domain.dtos.menuitem


data class MenuItemSummaryDto(
    val id: Long,
    val name: String,
    val price: Double,
    val image: String
)
