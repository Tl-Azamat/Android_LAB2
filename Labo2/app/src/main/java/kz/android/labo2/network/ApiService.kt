package kz.android.labo2.network

import kz.android.labo2.Dog
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("X-Api-Key:KMSA/02EPqpxJwqQ5jY4Qg==GgEGoXdjg6n5gErk")
    @GET("dogs")
    fun getDogs(@Query("name") name: String): Call<List<Dog>>
}