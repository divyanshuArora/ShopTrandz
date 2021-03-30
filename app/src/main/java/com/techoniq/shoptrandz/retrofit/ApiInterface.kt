package com.techoniq.shoptrandz.retrofit

import com.google.gson.GsonBuilder
import io.reactivex.Observable
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST

interface ApiInterface {


    @POST("get_data.php")
    fun getData(): Observable<JSONObject>


    companion object Factory {
        fun create(): ApiInterface {

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://24mpower.com/api/")
                .build()

            return retrofit.create(ApiInterface::class.java)

        }
    }
}