package com.yousef.helloworld.services.impl

import com.yousef.helloworld.domain.entities.MenuItem
import com.yousef.helloworld.respositories.MenuRepository
import com.yousef.helloworld.services.MenuService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MenuServiceImpl(private val menuRepository: MenuRepository): MenuService {
    override fun all(): List<MenuItem> {
        return menuRepository.findAll()
    }

    override fun findById(id: Long): MenuItem? {
        return menuRepository.findByIdOrNull(id)
    }

    override fun byRestaurantId(restaurantId: Long): List<MenuItem?>? {
        return menuRepository.findByRestaurantId(restaurantId=restaurantId)
    }

    override fun byRestaurantName(restaurantName: String): List<MenuItem?>? {
        return menuRepository.findByRestaurantName(restaurantName)
    }

    override fun create(menuItem: MenuItem): MenuItem {
        check(menuItem.id == null)
        return menuRepository.save(menuItem)
    }

    override fun update(menuItem: MenuItem): MenuItem {
        check(menuItem.id != null)
        return menuRepository.save(menuItem)
    }

    override fun delete(id: Long) {
        menuRepository.deleteById(id)
    }
}