package com.techoniq.shoptrandz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.techoniq.shoptrandz.R
import com.techoniq.shoptrandz.adapter.CategoriesAdapter
import com.techoniq.shoptrandz.adapter.CategoriesItemListAdapter
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.activity_category_items_list.*

class CategoryItemsListActivity : AppCompatActivity() {


    lateinit var categoryAdapter: CategoriesItemListAdapter
    private var arrayCategoryItemList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_items_list)

        setCategoryArray()
    }


    private fun setCategoryArray() {
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")
        arrayCategoryItemList.add("")

        setCategoryAdapter()
    }

    private fun setCategoryAdapter() {
        categoryItemsList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        categoryItemsList.adapter = CategoriesItemListAdapter(this, arrayCategoryItemList)
    }
}
