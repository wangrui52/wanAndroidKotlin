package com.example.wangrui.wanandroidkotlin.utils

import com.example.wangrui.wanandroidkotlin.Interface
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitUtil {

    /**
     * 据说这是kotlin中的单例模式，先写写试试
     */

    fun <T> initRetrofit(clazz : Class<T>) : T {
        val builder = OkHttpClient.Builder()
                .readTimeout(60,TimeUnit.SECONDS)
                .connectTimeout(60,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
        val retrofit = Retrofit.Builder()
                .baseUrl(Interface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build()
        return retrofit.create(clazz)

    }

}