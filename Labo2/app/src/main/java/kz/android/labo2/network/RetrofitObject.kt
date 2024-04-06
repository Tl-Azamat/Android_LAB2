package kz.android.labo2.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.api-ninjas.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}