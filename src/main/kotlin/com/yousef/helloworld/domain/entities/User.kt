package com.yousef.helloworld.domain.entities

import jakarta.persistence.*


@Entity
@Table(name = "users")
data class User(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "username")
    val username: String,

    @Column(name = "name")
    val name: String
)