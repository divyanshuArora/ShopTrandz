package com.techoniq.shoptrandz.retrofit.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.techoniq.shoptrandz.retrofit.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

class GetCategoriesClassRepo {
    companion object GetCategoriesClass
    {
        fun getInstance(): GetCategoriesClassRepo
        {
            return GetCategoriesClassRepo()
        }
    }


    fun GetCategoriesData(): LiveData<JSONObject>
    {
        var data = MutableLiveData<JSONObject>()

        ApiInterface.create().getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({data.value = it},{
                Log.d("RegisterRepo","${it.message}")
            })
        return  data
    }

}