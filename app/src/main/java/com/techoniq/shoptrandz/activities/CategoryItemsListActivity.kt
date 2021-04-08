package com.techoniq.shoptrandz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.techoniq.shoptrandz.R
import com.techoniq.shoptrandz.adapter.CategoriesItemListAdapter
import com.techoniq.shoptrandz.retrofit.model.ShopDetailsData
import com.techoniq.shoptrandz.retrofit.requests.ShopDetailsListRequest
import com.techoniq.shoptrandz.retrofit.viewmodel.GetShopListDetailsViewModel
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.activity_category_items_list.*

class CategoryItemsListActivity : AppCompatActivity() {


    lateinit var categoryAdapter: CategoriesItemListAdapter
    private var arrayCategoryItemList = ArrayList<ShopDetailsData>()
    var selectedCatId = ""
    lateinit var getShopListDetailsViewModel: GetShopListDetailsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_items_list)

        init()
    }

    private fun init() {
        selectedCatId = intent.getStringExtra("cat_id") ?: "0"
        Log.d("CatItemListAct", "selectedCatId => $selectedCatId")

        Glide.with(this).load(intent.getStringExtra("seleted_cat_image")).into(catImg)
        catTitle.text = intent.getStringExtra("selected_cat_name")

        getShopListDetailsViewModel =
            ViewModelProvider(this)[GetShopListDetailsViewModel::class.java]

        callApi()
    }

    private fun callApi() {
        progressCatItemList.visibility = View.VISIBLE
        val catDetailsRequest = ShopDetailsListRequest(selectedCatId)
        getShopListDetailsViewModel.getDataList(catDetailsRequest).observe(this, Observer {
            Log.d("CatItemListAct", "it=> $it")
            if (it.error == "0" && it.data.isNotEmpty()) {
                totalShopCount.visibility = View.VISIBLE
                val type = if(it.count > 1){" Places"} else {" Place"}
                totalShopCount.text = it.count.toString() + type
                arrayCategoryItemList.addAll(it.data as ArrayList<ShopDetailsData>)
                categoryItemsList.visibility = View.VISIBLE
                noDataFound.visibility = View.GONE
                setCategoryAdapter()
            } else {
                categoryItemsList.visibility = View.GONE
                noDataFound.visibility = View.VISIBLE
                totalShopCount.visibility = View.GONE
            }
            progressCatItemList.visibility = View.GONE
        })
    }

    private fun setCategoryAdapter() {
        categoryItemsList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        categoryItemsList.adapter = CategoriesItemListAdapter(this, arrayCategoryItemList)
    }
}
