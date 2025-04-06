package com.yousef.helloworld.domain.dtos

data class AddFoodRequestDto(val user: String, val restaurant: String, val items: List<String>)
