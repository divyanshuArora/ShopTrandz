package com.techoniq.shoptrandz.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.techoniq.shoptrandz.R
import com.techoniq.shoptrandz.activities.CategoryItemDetailsActivity
import com.techoniq.shoptrandz.activities.CategoryItemsListActivity
import com.techoniq.shoptrandz.databinding.CategoryItemListBind
import com.techoniq.shoptrandz.databinding.FullScreenItemBind
import org.jetbrains.anko.startActivity

class FullScreenImageAdapter(var activity: Activity, var arrayList: ArrayList<String>) :
    RecyclerView.Adapter<FullScreenImageAdapter.ItemViewHolder>() {

    lateinit var fullScreenItemBind: FullScreenItemBind
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FullScreenImageAdapter.ItemViewHolder {
        fullScreenItemBind = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.full_screen_image_item,
            parent,
            false
        )
        return ItemViewHolder(fullScreenItemBind)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    class ItemViewHolder(var itemBind: FullScreenItemBind) :
        RecyclerView.ViewHolder(itemBind.root) {
        fun bind(item: String) {
            itemBind.executePendingBindings()
        }
    }
}