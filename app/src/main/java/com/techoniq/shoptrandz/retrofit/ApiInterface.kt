package com.techoniq.shoptrandz.retrofit

import com.google.gson.GsonBuilder
import com.techoniq.shoptrandz.retrofit.model.CategoriesResponse
import com.techoniq.shoptrandz.retrofit.model.ShopListDetailsResponse
import com.techoniq.shoptrandz.retrofit.requests.ShopDetailsListRequest
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("get_category.php")
    fun getData(): Observable<CategoriesResponse>

    @POST("shop_details.php")
    fun getShopDetails(@Body shopDetailsListRequest: ShopDetailsListRequest):Observable<ShopListDetailsResponse>


    //https://shoptrandz.com/api/get_category.php

    companion object Factory {
        fun create(): ApiInterface {

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://shoptrandz.com/api/")
                .build()

            return retrofit.create(ApiInterface::class.java)

        }
    }
}