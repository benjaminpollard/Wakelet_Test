package com.idea.group.wakelet.views.factorys

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.idea.group.wakelet.controllers.PhotographerDetailViewModel
import com.idea.group.wakelet.controllers.PhotographerViewModel
import com.idea.group.wakelet.repositories.PhotographerRepository


class PhotographerDetailViewModelFactory(var photographerRepository: PhotographerRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PhotographerDetailViewModel(photographerRepository) as T
    }

}