package com.idea.group.wakelet.controllers

import androidx.lifecycle.ViewModel
import com.idea.group.wakelet.repositories.PhotographerRepository

class PhotographerViewModel(private val photographerRepository : PhotographerRepository) : ViewModel()
{
   fun getPhotographerList() = photographerRepository.getPhotographers()
}