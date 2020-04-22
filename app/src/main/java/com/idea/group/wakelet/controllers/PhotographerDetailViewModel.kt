package com.idea.group.wakelet.controllers

import androidx.lifecycle.ViewModel
import com.idea.group.wakelet.models.PhotographerModel
import com.idea.group.wakelet.repositories.PhotographerRepository

class PhotographerDetailViewModel(private val photographerRepository : PhotographerRepository) : ViewModel()
{
    fun getPhotographerByName(name: String) : PhotographerModel
    {
        val model = photographerRepository.getPhotographers().firstOrNull { photographerModel -> photographerModel.name == name }
        return model ?: PhotographerModel()
    }
}