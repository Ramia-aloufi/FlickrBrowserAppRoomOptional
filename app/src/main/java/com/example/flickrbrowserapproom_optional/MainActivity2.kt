package com.example.flickrbrowserapproom_optional

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    lateinit var rv1:RecyclerView
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        rv1 = findViewById(R.id.rv1)
        var all = arrayListOf<Item1>()
        var itm = ItemDatabase.getInstance(this).ItemDao().getAll()
        for (i in itm){
            all.add(i)
        }
        Log.d("all","$all")

        rv1.adapter?.notifyDataSetChanged()
        rv1.adapter = MyAdapter(this,all)
        rv1.layoutManager = LinearLayoutManager(this)

    }
}