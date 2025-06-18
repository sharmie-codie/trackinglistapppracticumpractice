package com.example.travelpackingapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Listactivity : AppCompatActivity() {

    private lateinit var tvItemList: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listactivity)

        tvItemList = findViewById(R.id.tvItemList)

        // Retrieve data from MainActivity
        val items = intent.getStringArrayListExtra("ITEMS") ?: arrayListOf()
        val categories = intent.getStringArrayListExtra("CATEGORIES") ?: arrayListOf()
        val quantities = intent.getIntegerArrayListExtra("QUANTITIES") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("COMMENTS") ?: arrayListOf()

        // Button click listeners
        findViewById<Button>(R.id.btnShowAll).setOnClickListener {
            displayItems(items, categories, quantities, comments)
        }

        findViewById<Button>(R.id.btnShowQuantity).setOnClickListener {
            val filteredItems = items.indices.filter { quantities[it] >= 2 }
            if (filteredItems.isEmpty()) {
                tvItemList.text = "No items with quantity ≥ 2"
            } else {
                displayItems(
                    filteredItems.map { items[it] },
                    filteredItems.map { categories[it] },
                    filteredItems.map { quantities[it] },
                    filteredItems.map { comments[it] }
                )
            }
        }

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }

    private fun displayItems(
        items: List<String>,
        categories: List<String>,
        quantities: List<Int>,
        comments: List<String>
    ) {
        val stringBuilder = StringBuilder()
        for (i in items.indices) {
            stringBuilder.append("""
                Item: ${items[i]}
                Category: ${categories[i]}
                Quantity: ${quantities[i]}
                Comments: ${comments[i]}
                
                """.trimIndent())
        }
        tvItemList.text = stringBuilder.toString()
    }
}