package com.jquiroga.accordiondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jquiroga.accordiondemo.adapter.NewspaperAdapter
import com.jquiroga.accordiondemo.utils.JsonHelper
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newspaperAdapter = NewspaperAdapter()

        val newspaperList = JsonHelper(this).getNewspaperData()!!

        newspaperAdapter.addNews(newspaperList)

        rcvNewspapers.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newspaperAdapter
        }

    }
}
