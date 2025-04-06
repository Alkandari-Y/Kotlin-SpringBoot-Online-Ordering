package com.yousef.helloworld.domain.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "restaurants")
data class Restaurant(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", unique = true)
    val name: String = "",

    @Column(name = "logo")
    val logo: String = "",

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    val menuItems: List<MenuItem> = emptyList()
)