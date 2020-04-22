package com.idea.group.waklet.controllers

import com.idea.group.waklet.models.PhotographerModel
import com.idea.group.waklet.repositories.PhotographerRepository

class PhotographerDetailController(private val photographerRepository : PhotographerRepository)
{
    fun getPhotographerByName(name: String) : PhotographerModel
    {
        val model = photographerRepository.getPhotographers().firstOrNull { photographerModel -> photographerModel.name == name }
        return model ?: PhotographerModel()
    }
}