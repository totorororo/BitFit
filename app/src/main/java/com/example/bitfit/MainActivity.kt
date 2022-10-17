package com.example.bitfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_activity)

        val fragmentManager: FragmentManager = supportFragmentManager

        // define your fragments here
        val logsFragment: Fragment = LogListFragment()
        val dashboardListFragment: Fragment = DashboardFragment()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)


        // handle navigation selection
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.action_logs -> fragment = logsFragment
                R.id.action_dashboard -> fragment = dashboardListFragment
            }
            replaceFragment(fragment)
            true
        }

        // Set default selection
        bottomNavigationView.selectedItemId = R.id.action_logs


        findViewById<Button>(R.id.AddButton).setOnClickListener {
            val i = Intent(this@MainActivity, ListActivity::class.java)

            //val itemsList = ArrayList<Item>()
            //itemsList.addAll(items)

            //i.putExtra("item", itemsList)
            startActivity(i)
        }

    }

    private fun replaceFragment(AllFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.log_frame_layout, AllFragment)
        fragmentTransaction.commit()
    }


}