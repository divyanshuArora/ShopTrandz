package com.techoniq.shoptrandz.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import com.techoniq.shoptrandz.R
import com.techoniq.shoptrandz.activities.CategoryItemsListActivity
import com.techoniq.shoptrandz.databinding.SliderViewPagerItemBind
import org.jetbrains.anko.startActivity

class SliderViewPagerAdapter(var activity: Activity, var arrayList: ArrayList<String>) :
    SliderViewAdapter<SliderViewPagerAdapter.ItemViewHolder>() {

    lateinit var sliderViewPagerItemBind: SliderViewPagerItemBind

    override fun onCreateViewHolder(parent: ViewGroup?): ItemViewHolder {
        sliderViewPagerItemBind = DataBindingUtil.inflate(
            LayoutInflater.from(parent?.context),
            R.layout.slider_view_pager_item,
            parent,
            false
        )
        return ItemViewHolder(sliderViewPagerItemBind)
    }

    override fun getCount(): Int {
       return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(arrayList[position])
        Glide.with(activity).load("https://shoptrandz.com/"+arrayList[position]).into(holder.itemBind.sliderImage)
    }

    class ItemViewHolder(var itemBind: SliderViewPagerItemBind) :
        SliderViewAdapter.ViewHolder(itemBind.root) {
        fun bind(item: String) {
            itemBind.executePendingBindings()
        }
    }


}