package com.example.bitfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val items = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_activity)

        val rvItems = findViewById<View>(R.id.entityRV) as RecyclerView
        val adapter = EntityAdapter(this, items)

        lifecycleScope.launch {

        Log.println(Log.ASSERT, items.toString(), "CHECK")
            (application as MyApplication).db.entityDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    Item(
                        entity.titleDesc,
                        entity.value
                    )
                }.also { mappedList ->
                    //items.clear()
                    items.addAll(mappedList)
                    adapter.notifyItemInserted(items.size-1)
                }
            }
            Log.println(Log.ASSERT, items.toString(), "CHECK")
        }



        rvItems.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            rvItems.addItemDecoration(dividerItemDecoration)
        }
        rvItems.adapter = adapter


        findViewById<Button>(R.id.AddButton).setOnClickListener {
            val i = Intent(this@MainActivity, ListActivity::class.java)

            //val itemsList = ArrayList<Item>()
            //itemsList.addAll(items)

            //i.putExtra("item", itemsList)
            startActivity(i)
        }
    }


}