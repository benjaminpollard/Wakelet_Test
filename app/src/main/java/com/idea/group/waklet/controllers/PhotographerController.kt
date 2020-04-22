package com.idea.group.waklet.controllers

import com.idea.group.waklet.repositories.PhotographerRepository

class PhotographerController(private val photographerRepository : PhotographerRepository)
{
   fun getPhotographerList() = photographerRepository.getPhotographers()
}