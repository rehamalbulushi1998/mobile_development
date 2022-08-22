package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.model.UnsplashItem
import kotlinx.android.synthetic.main.image_layout.view.*

class UnsplashAdapter (

    private val unsplashItem: List<UnsplashItem>
    ) : RecyclerView.Adapter<UnsplashAdapter.UnsplashViewHolder>() {

    class UnsplashViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindUnsplash(unsplashItem: UnsplashItem) {
            itemView.views_detail.text = unsplashItem.views.toString()
            itemView.Dowlodes_detail.text = unsplashItem.downloads.toString()
            itemView.Likes_detail.text = unsplashItem.likes.toString()
            itemView.dimension_width.text = unsplashItem.width.toString()
            itemView.dimension_height.text = unsplashItem.height.toString()
            itemView.city.text = unsplashItem.location.city
            itemView.country.text = unsplashItem.location.country
            itemView.city_tag.text = unsplashItem.location.city
            itemView.user_name.text = unsplashItem.user.username
            itemView.camera_detaile.text = unsplashItem.exif.name
            itemView.ISO_detail.text = unsplashItem.exif.iso.toString()
            itemView.aperture_detail.text = unsplashItem.exif.aperture
            itemView.focal_length_detail.text = unsplashItem.exif.focal_length
            itemView.shutter_speed_detail.text = unsplashItem.exif.exposure_time
            Glide.with(itemView).load(unsplashItem.urls.raw).into(itemView.image)
            Glide.with(itemView).load(unsplashItem.profile_image.large).into(itemView.profile_pic)
        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnsplashViewHolder {
            return UnsplashViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.image_layout, parent, false)
            )
        }

        override fun getItemCount(): Int = unsplashItem.size

        override fun onBindViewHolder(holder: UnsplashViewHolder, position: Int) {
            holder.bindUnsplash(unsplashItem.get(position))
        }
    }
