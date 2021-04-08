package com.techoniq.shoptrandz.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.techoniq.shoptrandz.R
import com.techoniq.shoptrandz.activities.FullScreenMenuImagesActivity
import com.techoniq.shoptrandz.databinding.RowMenuItemBind
import org.jetbrains.anko.startActivity

class MenuGridPhotosAdapter(var activity: Activity, var arrayList: ArrayList<String>) :
    RecyclerView.Adapter<MenuGridPhotosAdapter.ItemViewHolder>() {

    lateinit var rowMenuItemBind: RowMenuItemBind
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuGridPhotosAdapter.ItemViewHolder {
        rowMenuItemBind = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_menu_item,
            parent,
            false
        )
        return ItemViewHolder(rowMenuItemBind)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MenuGridPhotosAdapter.ItemViewHolder, position: Int) {
        holder.bind(arrayList[position])

        Glide.with(activity).load("https://shoptrandz.com/"+arrayList[position]).into(holder.itemBind.categoryImage)

        holder.itemBind.mainCategoryCardView.setOnClickListener {
            activity.startActivity<FullScreenMenuImagesActivity>(
                "ARRAY_OF_IMAGES" to arrayList,
                "SELECTED_POSITION" to position
            )
        }

    }

    class ItemViewHolder(var itemBind: RowMenuItemBind) :
        RecyclerView.ViewHolder(itemBind.root) {
        fun bind(item: String) {
            itemBind.executePendingBindings()
        }
    }
}