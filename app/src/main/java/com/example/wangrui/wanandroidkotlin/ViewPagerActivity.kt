package com.example.wangrui.wanandroidkotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.wangrui.wanandroidkotlin.adapter.ViewPagerAdapter
import com.example.wangrui.wanandroidkotlin.fragment.GongzhongFragment
import com.example.wangrui.wanandroidkotlin.fragment.HomeFragment
import com.example.wangrui.wanandroidkotlin.fragment.KnowledgeFragment

class ViewPagerActivity : AppCompatActivity() {
    private val mList:MutableList<Fragment> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        initFragment()
        initViewPager()
    }

    private fun initFragment() {
        val homeFragment = HomeFragment()
        val knowledgeFragment = KnowledgeFragment()
        val gongzhongFragment = GongzhongFragment()
        mList.add(homeFragment)
        mList.add(knowledgeFragment)
        mList.add(gongzhongFragment)
    }

    private fun initViewPager() {
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val myAdapter = ViewPagerAdapter(mList,supportFragmentManager)
        viewPager.adapter = myAdapter
    }
}