package com.yousef.helloworld.domain.entities

import jakarta.persistence.*


@Entity
@Table(name = "cart_items")
data class CartIem (
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val cartId: Long,
    val menuItemId: Long,
    val quantity: Int
)