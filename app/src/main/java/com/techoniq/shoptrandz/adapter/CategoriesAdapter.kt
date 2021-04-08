package com.techoniq.shoptrandz.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.techoniq.shoptrandz.R
import com.techoniq.shoptrandz.activities.CategoryItemsListActivity
import com.techoniq.shoptrandz.databinding.CategoriesItemBind
import com.techoniq.shoptrandz.retrofit.model.CategoriesData
import org.jetbrains.anko.startActivity

class CategoriesAdapter(var activity: Activity, var arrayList: ArrayList<CategoriesData>) :
    RecyclerView.Adapter<CategoriesAdapter.ItemViewHolder>() {

    lateinit var categoriesItemBind: CategoriesItemBind
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.ItemViewHolder {
        categoriesItemBind = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_category_items,
            parent,
            false
        )
        return ItemViewHolder(categoriesItemBind)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.ItemViewHolder, position: Int) {
        holder.bind(arrayList[position])
        holder.itemBind.mainCategoryCardView.setOnClickListener {
            activity.startActivity<CategoryItemsListActivity>("cat_id" to arrayList[position].categoryId,"seleted_cat_image" to arrayList[position].categoryImage, "selected_cat_name" to arrayList[position].categoryName)
        }
    }


    fun addFilterList(arrayOfCategories: ArrayList<CategoriesData>) {
        this.arrayList = arrayOfCategories
        notifyDataSetChanged()
    }


    class ItemViewHolder(var itemBind: CategoriesItemBind) :
        RecyclerView.ViewHolder(itemBind.root) {
        fun bind(item: CategoriesData) {
            itemBind.categoriesModel = item
            itemBind.executePendingBindings()
        }
    }
}