package com.techoniq.shoptrandz.retrofit.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.techoniq.shoptrandz.retrofit.ApiInterface
import com.techoniq.shoptrandz.retrofit.model.CategoriesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers



class GetCategoriesClassRepo {
    companion object GetCategoriesClass {
        fun getInstance(): GetCategoriesClassRepo {
            return GetCategoriesClassRepo()
        }
    }


    fun getCategoriesData(): LiveData<CategoriesResponse> {
        val data = MutableLiveData<CategoriesResponse>()

        ApiInterface.create().getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                data.value = it
                Log.d("GetCategoriesClassRepo", "it=> ${it}")
            }, {
                Log.d("GetCategoriesClassRepo", "${it.message}")
            })
        return data
    }

}