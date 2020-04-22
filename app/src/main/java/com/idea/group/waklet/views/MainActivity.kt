package com.idea.group.waklet.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.idea.group.waklet.controllers.PhotographerController
import com.idea.group.waklet.R
import com.idea.group.waklet.repositories.PhotographerRepository
import com.idea.group.waklet.views.interfaces.OnPhotographerClicked
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , OnPhotographerClicked {

    private val photographerController = PhotographerController(PhotographerRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        photographer_recycler_view.layoutManager = GridLayoutManager(this,2)
        photographer_recycler_view.adapter = PhotographerAdaptor(photographerController.getPhotographerList(),this)

    }

    override fun onPhotographerClicked(name: String) {
        val intent = Intent(this,PhotographerDetailActivity::class.java)
        intent.putExtra(PhotographerDetailActivity.PHOTOGRAPHER_DETAIL,name)
        startActivity(intent)
    }
}
