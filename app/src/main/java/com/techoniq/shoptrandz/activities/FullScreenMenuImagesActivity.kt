package com.techoniq.shoptrandz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide.init
import com.techoniq.shoptrandz.R
import com.techoniq.shoptrandz.adapter.FullScreenImageAdapter
import com.techoniq.shoptrandz.databinding.FullScreenImageActBind

class FullScreenMenuImagesActivity : AppCompatActivity() {

    var arrayOfFullScreenImages = ArrayList<String>()
    var selectedPos = 0
    lateinit var fullScreenImageActBind: FullScreenImageActBind
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_menu_images)
        fullScreenImageActBind =
            DataBindingUtil.setContentView(this, R.layout.activity_full_screen_menu_images)
        init()
    }

    private fun init() {
        arrayOfFullScreenImages = intent.getStringArrayListExtra("ARRAY_OF_IMAGES")
        selectedPos = intent.getIntExtra("SELECTED_POSITION", 0)

        if (arrayOfFullScreenImages.size < 1) {
            fullScreenImageActBind.layoutPreNextBtn.visibility = View.GONE
        }

        fullScreenImageActBind.btnPrevious.setOnClickListener {
            kotlin.runCatching {
                fullScreenImageActBind.FullScreenImageViewPager.currentItem =
                    fullScreenImageActBind.FullScreenImageViewPager.currentItem - 1
            }.onFailure { it.printStackTrace() }
        }

        fullScreenImageActBind.btnNext.setOnClickListener {
            kotlin.runCatching {
                fullScreenImageActBind.FullScreenImageViewPager.currentItem =
                    fullScreenImageActBind.FullScreenImageViewPager.currentItem + 1
            }.onFailure { it.printStackTrace() }
        }
        setArrayOfFullScreenImages()
    }

    private fun setArrayOfFullScreenImages() {
        fullScreenImageActBind.FullScreenImageViewPager.adapter =
            FullScreenImageAdapter(this, arrayOfFullScreenImages)
        fullScreenImageActBind.FullScreenImageViewPager.currentItem = selectedPos
    }
}
