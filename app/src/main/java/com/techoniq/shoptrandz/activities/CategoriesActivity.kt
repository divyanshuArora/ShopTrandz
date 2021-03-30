package com.techoniq.shoptrandz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide.init
import com.techoniq.shoptrandz.R
import com.techoniq.shoptrandz.adapter.CategoriesAdapter
import com.techoniq.shoptrandz.retrofit.viewmodel.GetDataViewModel
import kotlinx.android.synthetic.main.activity_categories.*

class CategoriesActivity : AppCompatActivity() {

    lateinit var getDataVM: GetDataViewModel
    private var arrayOfCategories = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        init()

    }

    private fun init() {
        getDataVM = ViewModelProvider(this)[GetDataViewModel::class.java]

        callGetDataApi()

    }

    private fun callGetDataApi() {
        getDataVM.getDataList().observe(this, Observer {
            Log.d("CategoriesActivity", "it=> $it")
        })

        setCategoryArray()
    }

    private fun setCategoryArray() {
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")
        arrayOfCategories.add("")

        setCategoryAdapter()
    }

    private fun setCategoryAdapter() {
        categoryRecyclerview.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        categoryRecyclerview.adapter = CategoriesAdapter(this, arrayOfCategories)
    }
}
