package com.techoniq.shoptrandz.retrofit.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.techoniq.shoptrandz.retrofit.model.ShopListDetailsResponse
import com.techoniq.shoptrandz.retrofit.repositories.GetShopListDetailsClassRepo
import com.techoniq.shoptrandz.retrofit.requests.ShopDetailsListRequest

class GetShopListDetailsViewModel(application: Application) : AndroidViewModel(application) {
    fun getDataList(selectedCatId: ShopDetailsListRequest): LiveData<ShopListDetailsResponse> {
        return GetShopListDetailsClassRepo.getInstance().getShopListDetails(selectedCatId)
    }
}