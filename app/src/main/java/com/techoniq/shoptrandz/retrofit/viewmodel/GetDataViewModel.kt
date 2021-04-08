package com.techoniq.shoptrandz.retrofit.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.techoniq.shoptrandz.retrofit.model.CategoriesResponse
import com.techoniq.shoptrandz.retrofit.repositories.GetCategoriesClassRepo
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response

class GetDataViewModel(application: Application) : AndroidViewModel(application) {
    fun getDataList(): LiveData<CategoriesResponse> {
        return GetCategoriesClassRepo.getInstance().getCategoriesData()
    }
}