package com.yousef.helloworld.domain.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*


@Entity
@Table(name = "menu_items")
data class MenuItem (
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.DETACH])
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonBackReference
    val restaurant: Restaurant? = null,

    @Column(name = "name")
    val name: String="",

    @Column(name = "price")
    val price: Double = 0.0,

    @Column(name="image")
    val image: String = ""

)