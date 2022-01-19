package com.task.data.api

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class NetworkModule {
    private val moshi by lazy {
        val moshiBuilder = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
        moshiBuilder.build()
    }

    private val loggingInterceptor by lazy {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        loggingInterceptor
    }

    private val httpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private fun CreateHttp(interceptor: Interceptor): OkHttpClient {
         return OkHttpClient.Builder()
            .addInterceptor( interceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }
    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("http://40.127.194.127:5656/Salamtak/")
            .client(CreateHttp(AuthInterceptor()))
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun createApi(): APIEndPoint {
        val retrofit = getRetrofit()
        return retrofit.create(APIEndPoint::class.java)
    }


}