package com.example.wangrui.wanandroidkotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.wangrui.wanandroidkotlin.R

class MainActivityAdapter (context: Context, list: Array<Any>) : RecyclerView.Adapter<MainActivityAdapter.MainViewHolder>() {

    private val mContext = context
    private val mList = list
    private var listener : onItemClickListener? = null


    interface onItemClickListener {
        fun onItemclickListener (position: Int)
    }

    fun setOnItemClickListener(itemClickListener: onItemClickListener) {
        this.listener = itemClickListener
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainViewHolder {
        val inflater = LayoutInflater.from(mContext).inflate(R.layout.mian_recycle_item,null,false)
        return MainViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.textView.text = mList.get(position).toString()
        holder.textView.setOnClickListener{
            listener?.onItemclickListener(position)
        }

    }


    class MainViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView :TextView = itemView.findViewById(R.id.item_textView)

    }
}