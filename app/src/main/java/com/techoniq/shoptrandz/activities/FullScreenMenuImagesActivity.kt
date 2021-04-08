package com.techoniq.shoptrandz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide.init
import com.techoniq.shoptrandz.R
import com.techoniq.shoptrandz.adapter.FullScreenImageAdapter
import com.techoniq.shoptrandz.databinding.FullScreenImageActBind
import kotlinx.android.synthetic.main.activity_full_screen_menu_images.*
import kotlinx.android.synthetic.main.activity_full_screen_menu_images.view.*

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

        FullScreenImageViewPager.isUserInputEnabled = false

        if (arrayOfFullScreenImages.size < 1) {
            fullScreenImageActBind.layoutPreNextBtn.visibility = View.GONE
        } else {
            setAdapter()
        }

        fullScreenImageActBind.layoutPreNextBtn.imageNumber.text = "${fullScreenImageActBind.FullScreenImageViewPager.currentItem + 1} / ${arrayOfFullScreenImages.size}"

        fullScreenImageActBind.btnPrevious.setOnClickListener {
            kotlin.runCatching {
                fullScreenImageActBind.FullScreenImageViewPager.currentItem =
                    fullScreenImageActBind.FullScreenImageViewPager.currentItem - 1

                fullScreenImageActBind.layoutPreNextBtn.imageNumber.text = "${fullScreenImageActBind.FullScreenImageViewPager.currentItem + 1 } / ${arrayOfFullScreenImages.size}"
            }.onFailure { it.printStackTrace() }
        }

        fullScreenImageActBind.btnNext.setOnClickListener {
            kotlin.runCatching {
                fullScreenImageActBind.FullScreenImageViewPager.currentItem =
                    fullScreenImageActBind.FullScreenImageViewPager.currentItem + 1

                fullScreenImageActBind.layoutPreNextBtn.imageNumber.text = "${fullScreenImageActBind.FullScreenImageViewPager.currentItem + 1} / ${arrayOfFullScreenImages.size}"
            }.onFailure { it.printStackTrace() }
        }
        
    }

    private fun setAdapter() {
        fullScreenImageActBind.FullScreenImageViewPager.adapter =
            FullScreenImageAdapter(this, arrayOfFullScreenImages)
        fullScreenImageActBind.FullScreenImageViewPager.currentItem = selectedPos
    }
}
