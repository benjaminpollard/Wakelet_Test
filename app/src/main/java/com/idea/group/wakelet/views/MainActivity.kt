package com.idea.group.wakelet.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.idea.group.wakelet.controllers.PhotographerViewModel
import com.idea.group.wakelet.R
import com.idea.group.wakelet.repositories.PhotographerRepository
import com.idea.group.wakelet.views.factorys.PhotographerViewModelFactory
import com.idea.group.wakelet.views.interfaces.OnPhotographerClicked
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , OnPhotographerClicked {

    private lateinit var photographerController :PhotographerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        photographerController = PhotographerViewModelFactory(PhotographerRepository()).create(PhotographerViewModel::class.java)

        photographer_recycler_view.layoutManager = GridLayoutManager(this,2)
        photographer_recycler_view.adapter = PhotographerAdaptor(photographerController.getPhotographerList(),this)

    }

    override fun onPhotographerClicked(name: String) {
        val intent = Intent(this,PhotographerDetailActivity::class.java)
        intent.putExtra(PhotographerDetailActivity.PHOTOGRAPHER_DETAIL,name)
        startActivity(intent)
    }
}
