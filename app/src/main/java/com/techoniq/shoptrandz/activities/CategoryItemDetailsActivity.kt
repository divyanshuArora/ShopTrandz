package com.techoniq.shoptrandz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderView
import com.techoniq.shoptrandz.R
import com.techoniq.shoptrandz.adapter.MenuGridPhotosAdapter
import com.techoniq.shoptrandz.adapter.SliderViewPagerAdapter
import com.techoniq.shoptrandz.databinding.CategoryItemDetails
import com.techoniq.shoptrandz.retrofit.model.ShopDetailsData

class CategoryItemDetailsActivity : AppCompatActivity() {

    lateinit var categoryItemBind: CategoryItemDetails
    private var arrayOfSlider = ArrayList<String>()
    private var arrayOfGridPhotos = ArrayList<String>()
    private lateinit var selectedModelData: ShopDetailsData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryItemBind =
            DataBindingUtil.setContentView(this, R.layout.activity_category_item_details)

        init()
    }

    private fun init() {
        val selectedShopModel =
            Gson().fromJson(intent.extras?.getString("ShopsListArray"), ShopDetailsData::class.java)
        Log.d("CateoryItemDetailsAct", "selectedShopModel=> $selectedShopModel")

        categoryItemBind.nameTxt.text = selectedShopModel.shopName
        categoryItemBind.addressTxt.text = selectedShopModel.shopAddress
        categoryItemBind.ratingTxt.text = selectedShopModel.shopRating
        categoryItemBind.ratingBar.rating = selectedShopModel.shopRating.toFloat()
        categoryItemBind.shopStatusTxt.text = selectedShopModel.shopStatus + ":"
        categoryItemBind.shopTimingTxt.text =
            selectedShopModel.opeingTime + "-" + selectedShopModel.closingTime

        categoryItemBind.numberTxt.text = selectedShopModel.mobileOne +", "+ selectedShopModel.mobileTwo
        setCategoryArray(selectedShopModel.sliderPhotos, selectedShopModel.productsPhotos)
    }


    private fun setCategoryArray(
        sliderPhotos: List<String>,
        productsPhotos: List<String>
    ) {
        arrayOfSlider.addAll(sliderPhotos)
        arrayOfGridPhotos.addAll(productsPhotos)
        setSliderAdapter()
        setPhotosAdapter()
    }

    private fun setSliderAdapter() {
        categoryItemBind.imageSlider.setSliderAdapter(SliderViewPagerAdapter(this, arrayOfSlider))
        categoryItemBind.imageSlider.setIndicatorAnimation(IndicatorAnimationType.SWAP)

        categoryItemBind.imageSlider.autoCycleDirection =
            SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH;

        categoryItemBind.imageSlider.scrollTimeInSec = 3
        categoryItemBind.imageSlider.startAutoCycle()
    }


    private fun setPhotosAdapter() {
        categoryItemBind.photosRecyclerView.layoutManager =
            GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false)
        categoryItemBind.photosRecyclerView.adapter = MenuGridPhotosAdapter(this, arrayOfGridPhotos)
    }
}
