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
import org.jetbrains.anko.startActivity

class CategoriesItemListAdapter(var activity: Activity, var arrayList: ArrayList<String>) :
    RecyclerView.Adapter<CategoriesItemListAdapter.ItemViewHolder>() {

    lateinit var CategoryItemListBind: CategoryItemListBind
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesItemListAdapter.ItemViewHolder {
        CategoryItemListBind = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.raw_category_list_item,
            parent,
            false
        )
        return ItemViewHolder(CategoryItemListBind)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: CategoriesItemListAdapter.ItemViewHolder, position: Int) {
        holder.bind(arrayList[position])

        holder.itemBind.categoryItemListCard.setOnClickListener {
            activity.startActivity<CategoryItemDetailsActivity>()
        }
    }

    class ItemViewHolder(var itemBind: CategoryItemListBind) :
        RecyclerView.ViewHolder(itemBind.root) {
        fun bind(item: String) {
            itemBind.executePendingBindings()
        }
    }
}