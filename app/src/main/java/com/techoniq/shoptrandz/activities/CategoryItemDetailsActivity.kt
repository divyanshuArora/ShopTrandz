package com.techoniq.shoptrandz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import com.techoniq.shoptrandz.R
import com.techoniq.shoptrandz.adapter.MenuGridPhotosAdapter
import com.techoniq.shoptrandz.adapter.SliderViewPagerAdapter
import com.techoniq.shoptrandz.databinding.CategoryItemDetails

class CategoryItemDetailsActivity : AppCompatActivity() {

    lateinit var categoryItemBind: CategoryItemDetails
    private var arrayOfSlider = ArrayList<String>()
    private var arrayOfGridPhotos = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryItemBind =
            DataBindingUtil.setContentView(this, R.layout.activity_category_item_details)

        setCategoryArray()
    }


    private fun setCategoryArray() {
        arrayOfSlider.add("")
        arrayOfSlider.add("")
        arrayOfSlider.add("")

        arrayOfGridPhotos.add("")
        arrayOfGridPhotos.add("")
        arrayOfGridPhotos.add("")
        arrayOfGridPhotos.add("")
        arrayOfGridPhotos.add("")
        arrayOfGridPhotos.add("")
        arrayOfGridPhotos.add("")
        arrayOfGridPhotos.add("")
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
