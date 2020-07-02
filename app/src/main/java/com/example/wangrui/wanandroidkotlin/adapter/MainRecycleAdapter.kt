package com.example.wangrui.wanandroidkotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.wangrui.wanandroidkotlin.R

class MainRecycleAdapter (context : Context,list : Array<Any>) : RecyclerView.Adapter<MainRecycleAdapter.ViewHolder>(){

    private val mContext = context
    private val mList = list

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(mContext).inflate(R.layout.mian_recycle_item,null,false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.textView.text = mList.get(p1).toString()
    }

    class ViewHolder(item :View) :RecyclerView.ViewHolder(item) {
        val textView :TextView = item.findViewById(R.id.item_title)
    }

}