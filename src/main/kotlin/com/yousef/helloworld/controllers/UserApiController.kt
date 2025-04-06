package com.yousef.helloworld.controllers

import com.yousef.helloworld.domain.dtos.users.UserCreateRequestDto
import com.yousef.helloworld.domain.dtos.users.UserDto
import com.yousef.helloworld.domain.toDto
import com.yousef.helloworld.domain.toEntity
import com.yousef.helloworld.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class UserApiController(private val userService: UserService) {
    @GetMapping
    fun getUsers(): ResponseEntity<List<UserDto>> {
        return ResponseEntity(
            userService.all()
                .map { it.toDto() }
            , HttpStatus.OK
        )
    }

    @PostMapping
    fun createUser(@RequestBody userCreateRequestDto: UserCreateRequestDto): ResponseEntity<UserDto> {
        return ResponseEntity(
            userService.createUser(
                userCreateRequestDto.toEntity())
            .toDto(),
            HttpStatus.CREATED)
    }
}
