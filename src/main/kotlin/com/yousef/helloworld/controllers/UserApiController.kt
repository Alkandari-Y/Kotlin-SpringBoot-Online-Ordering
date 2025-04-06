package com.yousef.helloworld.controllers

import com.yousef.helloworld.domain.dtos.users.UserDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class UserApiController {
    @GetMapping
    fun getUsers(): ResponseEntity<List<UserDto>> {
        return ResponseEntity(emptyList(), HttpStatus.OK)
    }
}
