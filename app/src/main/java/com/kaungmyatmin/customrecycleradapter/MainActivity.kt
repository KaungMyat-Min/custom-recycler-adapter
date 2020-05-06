package com.kaungmyatmin.customrecycleradapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),CustomDelegate {

    private val simpleAdapter = SimpleRecyclerAdapter<Info>(MyViewHolder::class.java,this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvTest.apply {
            adapter = simpleAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        simpleAdapter.setNewData(
            listOf(
                Info("adfasd"),
                Info("adfasd"),
                Info("adfasd"),
                Info("adfasd"),
                Info("adfasd")
            )
        )
    }
}
