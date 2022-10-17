package com.example.bitfit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class LogListFragment : Fragment() {

    private val items = mutableListOf<Item>()
    private lateinit var logsRecyclerView: RecyclerView
    private lateinit var entityAdapter: EntityAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Change this statement to store the view in a variable instead of a return statement
        val view = inflater.inflate(R.layout.fragment_log_list, container, false)

        // Add these configurations for the recyclerView and to configure the adapter
        val layoutManager = LinearLayoutManager(context)
        logsRecyclerView = view.findViewById(R.id.log_recycler_view)
        logsRecyclerView.layoutManager = layoutManager
        logsRecyclerView.setHasFixedSize(true)
        entityAdapter = EntityAdapter(view.context, items)
        logsRecyclerView.adapter = entityAdapter

        lifecycleScope.launch {

            (activity?.application as MyApplication).db.entityDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    Item(
                        entity.titleDesc,
                        entity.value
                    )
                }.also { mappedList ->
                    items.clear()
                    items.addAll(mappedList)
                    entityAdapter.notifyDataSetChanged()
                }
            }

        }

        // Update the return statement to return the inflated view from above
        return view
    }

    companion object {

        fun newInstance(): LogListFragment {
            return LogListFragment()
        }

    }
}