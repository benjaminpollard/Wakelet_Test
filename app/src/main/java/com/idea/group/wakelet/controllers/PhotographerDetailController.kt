package com.idea.group.wakelet.controllers

import com.idea.group.wakelet.models.PhotographerModel
import com.idea.group.wakelet.repositories.PhotographerRepository

class PhotographerDetailController(private val photographerRepository : PhotographerRepository)
{
    fun getPhotographerByName(name: String) : PhotographerModel
    {
        val model = photographerRepository.getPhotographers().firstOrNull { photographerModel -> photographerModel.name == name }
        return model ?: PhotographerModel()
    }
}