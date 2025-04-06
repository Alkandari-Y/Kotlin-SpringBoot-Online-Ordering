package com.yousef.helloworld.domain.entities

import jakarta.persistence.*

@Entity
@Table(name = "carts")
data class Cart (
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "user_id")
    @JoinColumn(name = "user_id")
    val userId: Long,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.DETACH])
    @JoinColumn(name = "restaurant_id")
    val restaurant: Restaurant
)
