package com.yousef.helloworld.entities.Dtos

data class AddFoodRequestDto(val user: String, val restaurant: String, val items: List<String>)
