package com.techoniq.shoptrandz.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.techoniq.shoptrandz.R

object CustomImageAdapter {
    @BindingAdapter("setImageFromUrl")
    @JvmStatic
    fun GetImage(imageView: ImageView, url: String)
    {
        Glide.with(imageView.context).load(url).into(imageView)
    }


    @BindingAdapter("setImageFromInt")
    @JvmStatic
    fun setDrawableImage(imageView: ImageView, url: Int)
    {
        //Glide.with(imageView.context).load(url).placeholder(R.drawable.not_found).error(R.drawable.not_found).into(imageView)

        imageView.setImageResource(url)

    }

}