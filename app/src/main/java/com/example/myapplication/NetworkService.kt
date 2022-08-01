package com.example.myapplication

import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.Interceptor
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import com.example.myapplication.Constants.BASE_URL
import java.util.concurrent.TimeUnit

class NetworkService private constructor() {
    private var mRetrofit: Retrofit
    fun getAuthorizeInstance(Token: String) {
        val httpClient = OkHttpClient.Builder().connectTimeout(5L,TimeUnit.SECONDS )
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(Interceptor { chain ->
            val request =
                chain.request().newBuilder().addHeader("Authorization", "Bearer $Token").build()
            chain.proceed(request)
        })
        httpClient.addInterceptor(interceptor)
        mRetrofit = Retrofit.Builder().addConverterFactory(buildGsonConverter()).baseUrl(BASE)
            .client(httpClient.build()).build()
    }

    val api: MySiteApi
        get() = mRetrofit.create(MySiteApi::class.java)

    companion object {
        private var mInstance: NetworkService? = null
        private val BASE = BASE_URL
        @JvmStatic
        val instance: NetworkService?
            get() {
                if (mInstance == null) {
                    mInstance = NetworkService()
                }
                return mInstance
            }

        private fun buildGsonConverter(): GsonConverterFactory {
            val gsonBuilder = GsonBuilder()
            gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val myGson = gsonBuilder.create()
            return GsonConverterFactory.create(myGson)
        }
    }
    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().connectTimeout(5L,TimeUnit.SECONDS ).addInterceptor(interceptor).build()
        mRetrofit = Retrofit.Builder().baseUrl(BASE).client(client)
            .addConverterFactory(buildGsonConverter()).build()
    }
}