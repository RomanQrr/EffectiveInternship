package ru.effective.internship.romanqrr.networking

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import ru.effective.internship.romanqrr.networking.json.CharacterDataWrapper

private const val BASE_URL = "https://gateway.marvel.com:443/v1/public"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MarvelAPIService{
    @GET("characters?orderBy=-modified&apikey={apiKey}")
    suspend fun getHeroes(@Path("apiKey") apiKey : String) : CharacterDataWrapper
}

object MarvelAPI {
    val retrofitService : MarvelAPIService by lazy{
        retrofit.create(MarvelAPIService::class.java)
    }
}