package com.example.bitfit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        lifecycleScope.launch(Dispatchers.IO) {

            var average = (activity?.application as MyApplication).db.entityDao().avgValues()
            view.findViewById<TextView?>(R.id.AverageValue).text = average
            var maximum = (activity?.application as MyApplication).db.entityDao().maxValues()
            view.findViewById<TextView?>(R.id.MaxValue).text = maximum
            var minimum = (activity?.application as MyApplication).db.entityDao().minValues()
            view.findViewById<TextView?>(R.id.MinValue).text = minimum
        }

        return view

    }

}