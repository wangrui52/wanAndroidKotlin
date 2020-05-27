package com.example.wangrui.wanandroidkotlin.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class ViewPagerAdapter(var list: List<Fragment>,fm:FragmentManager):FragmentStatePagerAdapter(fm) {
    override fun getItem(i: Int): Fragment {
        return list[i]
    }

    override fun getCount(): Int {
        return list.size
    }
}