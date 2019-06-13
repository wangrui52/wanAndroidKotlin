package com.example.wangrui.wanandroidkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.wangrui.wanandroidkotlin.adapter.MainActivityAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycle = findViewById<RecyclerView>(R.id.recycle)
        val stringArr = arrayOf("1","2",1,2,3)
        val intArr: IntArray = intArrayOf(1,2,3)
        val inta :IntArray = intArrayOf(1,9,8)
        val manager = LinearLayoutManager(this)
        val adapter  = MainActivityAdapter(this,stringArr)
        recycle.layoutManager = manager
        recycle.adapter = adapter
        adapter.setOnItemClickListener(object : MainActivityAdapter.onItemClickListener{
            override fun onItemclickListener(position: Int) {
                Toast.makeText(this@MainActivity,"点击"+position,Toast.LENGTH_SHORT).show()
                val intent  = Intent()
                intent.setClass(this@MainActivity,ViewPagerActivity::class.java)
                startActivity(intent)
            }
        })


    }
}
