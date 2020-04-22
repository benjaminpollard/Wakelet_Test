package com.idea.group.waklet.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.idea.group.waklet.models.PhotographerModel
import com.idea.group.waklet.R
import com.idea.group.waklet.views.interfaces.OnPhotographerClicked
import kotlinx.android.synthetic.main.row_item_photographer.view.*


class PhotographerAdaptor(private val photographerList: List<PhotographerModel>, val clickListener : OnPhotographerClicked)
    :RecyclerView.Adapter<PhotographerAdaptor.PhotographerHolder>()
{
    override fun onBindViewHolder(holder: PhotographerHolder, position: Int) {

        holder.name.text = photographerList[position].name ?: holder.name.context.getString(R.string.no_applicable)

        holder.cardView.tag = photographerList[position].name //use for on click later
        holder.cardView.setOnClickListener {
            clickListener.onPhotographerClicked(it.tag.toString())
        }

        val options: RequestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(holder.photo.context).load(photographerList[position].image).apply(options).into( holder.photo )
        holder.photo.contentDescription = photographerList[position].description

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotographerHolder {
        return PhotographerHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_item_photographer,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = photographerList.size


    class PhotographerHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v
        // private var photo: Photo? = null
        val photo: ImageView = view.row_item_photographer_main_image
        val name: TextView = view.row_item_photographer_name
        val cardView : CardView = view.row_item_photographer_cardview

    }
}