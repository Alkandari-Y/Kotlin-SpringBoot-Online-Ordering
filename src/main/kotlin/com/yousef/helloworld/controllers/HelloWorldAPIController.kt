package com.yousef.helloworld.contorllers

import com.yousef.helloworld.domain.dtos.HelloWorldDto
import com.yousef.helloworld.domain.dtos.AddFoodRequestDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/hey")
class HelloWorldAPIController {

    @GetMapping(path=["/hello-world"])
    fun helloWorldApi(): ResponseEntity<HelloWorldDto> =
        ResponseEntity(HelloWorldDto(message="Hello, World!"), HttpStatus.OK)

    @GetMapping(path=["/hello-menu"])
    fun helloMenuApi(): ResponseEntity<HelloWorldDto> =
        ResponseEntity(HelloWorldDto(message="Hello, NumNUm!"), HttpStatus.OK)

    @GetMapping(path=["/hello-cart"])
    fun cart(): ResponseEntity<HelloWorldDto> =
        ResponseEntity(HelloWorldDto(message="I make sure pizza is in the cart"), HttpStatus.OK)

    @PostMapping(path=["/hello-cart"])
    fun addToCart(@RequestBody foodRequestDto: AddFoodRequestDto)
            : ResponseEntity<AddFoodRequestDto> = ResponseEntity(foodRequestDto, HttpStatus.CREATED)

    @GetMapping(path=["/hello-checkout"])
    fun checkoutApi(): ResponseEntity<HelloWorldDto> =
        ResponseEntity(HelloWorldDto(message="Take my MONEY!"), HttpStatus.OK)

}