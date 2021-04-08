package com.techoniq.shoptrandz.retrofit.repositories

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.techoniq.shoptrandz.retrofit.ApiInterface
import com.techoniq.shoptrandz.retrofit.model.ShopListDetailsResponse
import com.techoniq.shoptrandz.retrofit.requests.ShopDetailsListRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class GetShopListDetailsClassRepo {
    companion object GetCategoriesClass {
        fun getInstance(): GetShopListDetailsClassRepo {
            return GetShopListDetailsClassRepo()
        }
    }


    @SuppressLint("CheckResult")
    fun getShopListDetails(selectedCatId: ShopDetailsListRequest): LiveData<ShopListDetailsResponse> {
        val data = MutableLiveData<ShopListDetailsResponse>()
        ApiInterface.create().getShopDetails(selectedCatId)
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