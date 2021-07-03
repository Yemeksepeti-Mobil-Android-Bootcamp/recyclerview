package com.kodluyoruz.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//Option-2 -> IFoodOnClick
class MainActivity : AppCompatActivity(), IFoodOnClick {

    lateinit var recyclerView: RecyclerView
    private var adapter: FoodsAdapter = FoodsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setData()
    }

    private fun setData() {
        val data = ArrayList<Item>()
        for (i in 0..100) {
            data.add(Item("name $i", "description - $i"))
        }
        adapter.setFoodList(data)
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)

        //Option-2
        adapter.addListener(this)

        // Option-1
//        adapter.addListener(object: IFoodOnClick {
//            override fun onClick(item: Item) {
//                item.sayHello()
//            }
//        })

        recyclerView.adapter = adapter
    }

    override fun onPause() {
        super.onPause()
        adapter.removeListeners()
    }

    //Option-2
    override fun onClick(item: Item) {
        item.sayHello()
    }
}