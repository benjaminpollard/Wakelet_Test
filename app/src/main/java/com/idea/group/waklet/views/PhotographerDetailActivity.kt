package com.idea.group.waklet.views

import android.os.Bundle
import android.text.util.Linkify
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.idea.group.waklet.controllers.PhotographerDetailController
import com.idea.group.waklet.models.PhotographerModel
import com.idea.group.waklet.R
import com.idea.group.waklet.repositories.PhotographerRepository

import kotlinx.android.synthetic.main.activity_photographer_detail.*

class PhotographerDetailActivity : AppCompatActivity() {

    private val photographerDetailController = PhotographerDetailController(PhotographerRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photographer_detail)
        val name = intent.getStringExtra(PHOTOGRAPHER_DETAIL)

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
