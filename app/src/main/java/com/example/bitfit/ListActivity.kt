package com.example.bitfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val item = getIntent().getSerializableExtra("item") as List<Item>

        findViewById<Button>(R.id.button).setOnClickListener {
            val food = findViewById<EditText>(R.id.FoodText).text.toString()
            val calorie = findViewById<EditText>(R.id.CalorieText).text.toString()

            lifecycleScope.launch(IO) {
                (application as MyApplication).db.entityDao().insert(
                    Entity(food, calorie)
                )
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}