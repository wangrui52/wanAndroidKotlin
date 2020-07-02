package com.example.wangrui.wanandroidkotlin

import com.example.wangrui.wanandroidkotlin.bean.BannerBean
import com.example.wangrui.wanandroidkotlin.bean.HomeListBean
import retrofit2.Call
import retrofit2.http.GET

interface GetRequest {
    //首页banner
    @GET(Interface.HOME_BANNER)
    fun getBannerDate() :Call<BannerBean>

    @GET(Interface.HOME_LIST)
    fun getHomeList() :Call<HomeListBean>

}