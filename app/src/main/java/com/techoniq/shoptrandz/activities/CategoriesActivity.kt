package com.techoniq.shoptrandz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.techoniq.shoptrandz.R
import com.techoniq.shoptrandz.adapter.CategoriesAdapter
import com.techoniq.shoptrandz.retrofit.model.CategoriesData
import com.techoniq.shoptrandz.retrofit.viewmodel.GetDataViewModel
import kotlinx.android.synthetic.main.activity_categories.*
import java.util.*
import kotlin.collections.ArrayList

class CategoriesActivity : AppCompatActivity() {

    lateinit var getDataVM: GetDataViewModel
    private var arrayOfCategories = ArrayList<CategoriesData>()
    private lateinit var categoriesAdapter: CategoriesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        init()
    }

    private fun init() {
        getDataVM = ViewModelProvider(this)[GetDataViewModel::class.java]

        searchCategories.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterData(s.toString())
            }
        })
        callGetDataApi()
    }


    private fun callGetDataApi() {
        progressbarCat.visibility = View.VISIBLE
        getDataVM.getDataList().observe(this, Observer {
            Log.d("CategoriesActivity", "it=> $it")
            if (it != null && it.error == "0") {
                arrayOfCategories.addAll(it.data as ArrayList<CategoriesData>)
                Log.d("CategoriesAct", "array size=>  ${arrayOfCategories.size}")
                if (arrayOfCategories.size > 0) {
                    setCategoryAdapter()
                    searchCategories.isFocusable = true
                    searchCategories.isCursorVisible = true
                    categoryRecyclerview.visibility = View.VISIBLE
                    noDataFoundCat.visibility = View.GONE
                } else {
                    searchCategories.isFocusable = false
                    searchCategories.isCursorVisible = false
                    categoryRecyclerview.visibility = View.GONE
                    noDataFoundCat.visibility = View.VISIBLE
                }
            }
            progressbarCat.visibility = View.GONE
        })
    }

    private fun setCategoryAdapter() {
        categoryRecyclerview.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        categoriesAdapter = CategoriesAdapter(this, arrayOfCategories)
        categoryRecyclerview.adapter = categoriesAdapter
    }

    private fun filterData(filterData: String) {
        val filterItemArray: ArrayList<CategoriesData> = ArrayList()
        val userArray: ArrayList<CategoriesData> = arrayOfCategories
        for (eachUser in userArray) {
            if (eachUser.categoryName.toLowerCase(Locale.getDefault()).contains(
                    filterData.toLowerCase(
                        Locale.getDefault()
                    )
                )
            ) {
                filterItemArray.add(eachUser)
                categoriesAdapter.addFilterList(filterItemArray)

            } else {
            }
        }
    }
}
