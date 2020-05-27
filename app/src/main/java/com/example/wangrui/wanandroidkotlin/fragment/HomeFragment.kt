package com.example.wangrui.wanandroidkotlin.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.wangrui.wanandroidkotlin.GetRequest
import com.example.wangrui.wanandroidkotlin.R
import com.example.wangrui.wanandroidkotlin.bean.BannerBean
import com.example.wangrui.wanandroidkotlin.bean.Data
import com.example.wangrui.wanandroidkotlin.utils.RetrofitUtil
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.banner_header.*
import retrofit2.Call
import retrofit2.Response


class HomeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.banner_header, null, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBannerDate()
    }

    private fun initBanner(image: MutableList<String>, title: MutableList<String>) {
        home_banner?.apply {
            setBannerAnimation(Transformer.DepthPage)
            setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
            isAutoPlay(true)
            setDelayTime(1500)
            setIndicatorGravity(BannerConfig.CENTER)
            setImageLoader(GlideImageLoader())
            setImages(image)
            setBannerTitles(title)
            start()
        }


    }

    private fun initRecycleView() {
        // main_recycle.adapter =
    }

    private fun getBannerDate() {
        val call = RetrofitUtil.initRetrofit(GetRequest::class.java).getBannerDate()
        call.enqueue(object : retrofit2.Callback<BannerBean> {
            override fun onFailure(call: Call<BannerBean>, t: Throwable) {
                Toast.makeText(activity, "失败", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<BannerBean>, response: Response<BannerBean>) {
                val dataArrary: List<Data>? = response.body()?.data
                val pathList: MutableList<String> = mutableListOf()
                val titleList: MutableList<String> = mutableListOf()
                if (dataArrary != null) {
                    for (data in dataArrary) {
                        val path = mutableListOf(data.imagePath)
                        val title = mutableListOf(data.title)
                        pathList.addAll(path)
                        titleList.addAll(title)
                    }
                    initBanner(pathList, titleList)
                }
            }
        })
    }

//    inner class GlideImageLoader : ImageLoader() {
//        override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
//            activity?.let { imageView?.let { it1 -> Glide.with(it).load(path).into(it1) } }
//        }
//
//    }

    class GlideImageLoader : ImageLoader() {
        override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
            if (context != null) {
                if (imageView != null) {
                    Glide.with(context).load(path).into(imageView)
                }
            }
        }

    }
}