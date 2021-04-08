package com.techoniq.shoptrandz.retrofit.requests

import com.google.gson.annotations.SerializedName

data class ShopDetailsListRequest(
    @SerializedName("cat_id")
    val cat_id: String
)