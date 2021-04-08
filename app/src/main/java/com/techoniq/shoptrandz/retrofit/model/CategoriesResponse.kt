package com.techoniq.shoptrandz.retrofit.model
import com.google.gson.annotations.SerializedName


data class CategoriesResponse(
    @SerializedName("data")
    var `data`: List<CategoriesData>,
    @SerializedName("error")
    var error: String,
    @SerializedName("message")
    var message: String
)

data class CategoriesData(
    @SerializedName("category_id")
    var categoryId: String,
    @SerializedName("category_image")
    var categoryImage: String,
    @SerializedName("category_name")
    var categoryName: String
)