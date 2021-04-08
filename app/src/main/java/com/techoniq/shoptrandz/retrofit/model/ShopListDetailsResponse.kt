package com.techoniq.shoptrandz.retrofit.model
import com.google.gson.annotations.SerializedName


data class ShopListDetailsResponse(
    @SerializedName("count")
    var count: Int,
    @SerializedName("data")
    var `data`: List<ShopDetailsData>,
    @SerializedName("error")
    var error: String,
    @SerializedName("message")
    var message: String
)

data class ShopDetailsData(
    @SerializedName("closing_time")
    var closingTime: String,
    @SerializedName("mobile_one")
    var mobileOne: String,
    @SerializedName("mobile_two")
    var mobileTwo: String,
    @SerializedName("opeing_time")
    var opeingTime: String,
    @SerializedName("products_photos")
    var productsPhotos: List<String>,
    @SerializedName("shop_address")
    var shopAddress: String,
    @SerializedName("shop_name")
    var shopName: String,
    @SerializedName("shop_rating")
    var shopRating: String,
    @SerializedName("shop_status")
    var shopStatus: String,
    @SerializedName("slider_photos")
    var sliderPhotos: List<String>
)