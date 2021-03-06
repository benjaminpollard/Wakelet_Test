package com.idea.group.wakelet.views

import android.os.Bundle
import android.text.util.Linkify
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.idea.group.wakelet.controllers.PhotographerDetailViewModel
import com.idea.group.wakelet.models.PhotographerModel
import com.idea.group.wakelet.R
import com.idea.group.wakelet.controllers.PhotographerViewModel
import com.idea.group.wakelet.repositories.PhotographerRepository
import com.idea.group.wakelet.views.factorys.PhotographerDetailViewModelFactory
import com.idea.group.wakelet.views.factorys.PhotographerViewModelFactory

import kotlinx.android.synthetic.main.activity_photographer_detail.*

class PhotographerDetailActivity : AppCompatActivity() {

    private lateinit var photographerDetailController :PhotographerDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photographer_detail)
        val name = intent.getStringExtra(PHOTOGRAPHER_DETAIL)

        photographerDetailController = PhotographerDetailViewModelFactory(PhotographerRepository()).create(
            PhotographerDetailViewModel::class.java)


        if(name != null)
            setUpUI(photographerDetailController.getPhotographerByName(name))
        else
            Toast.makeText(this,getString(R.string.no_matching_result),Toast.LENGTH_SHORT).show()
    }

    private fun setUpUI(photographerByName: PhotographerModel) {
        activity_photographer_detail_name.text = photographerByName.name ?: ""
        activity_photographer_detail_image_tag.text = photographerByName.description ?: ""

        activity_photographer_detail_bio.text = photographerByName.bio ?: ""

        Linkify.addLinks(activity_photographer_detail_bio, Linkify.ALL )

        val options: RequestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(this).load(photographerByName.image).apply(options).into( activity_photographer_detail_image )
        activity_photographer_detail_image.contentDescription =  photographerByName.description ?: getString(R.string.no_applicable)

    }

    companion object {
        const val PHOTOGRAPHER_DETAIL = "PHOTOGRAPHER_DETAIL"
    }

}
