package com.techoniq.shoptrandz.retrofit.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.techoniq.shoptrandz.retrofit.repositories.GetCategoriesClassRepo
import org.json.JSONObject

class GetDataViewModel(application: Application) : AndroidViewModel(application) {
    fun getDataList(): LiveData<JSONObject> {
        return GetCategoriesClassRepo.getInstance().GetCategoriesData()
    }
}