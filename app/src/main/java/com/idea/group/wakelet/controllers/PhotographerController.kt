package com.idea.group.wakelet.controllers

import com.idea.group.wakelet.repositories.PhotographerRepository

class PhotographerController(private val photographerRepository : PhotographerRepository)
{
   fun getPhotographerList() = photographerRepository.getPhotographers()
}