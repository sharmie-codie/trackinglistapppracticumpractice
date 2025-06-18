package com.example.travelpackingapp


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Parallel arrays to store items
    private val itemArray = arrayListOf<String>()
    private val categoryArray = arrayListOf<String>()
    private val quantityArray = arrayListOf<Int>()
    private val commentArray = arrayListOf<String>()

    // UI elements
    private lateinit var etItemName: EditText
    private lateinit var etCategory: EditText
    private lateinit var etQuantity: EditText
    private lateinit var etComments: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize EditText fields
        etItemName = findViewById(R.id.etItemName)
        etCategory = findViewById(R.id.etCategory)
        etQuantity = findViewById(R.id.etQuantity)
        etComments = findViewById(R.id.etComments)

        // Button click listeners
        findViewById<Button>(R.id.btnAddItem).setOnClickListener {
            addItemToArrays()
        }

        findViewById<Button>(R.id.btnViewList).setOnClickListener {
            navigateToListActivity()
        }

        findViewById<Button>(R.id.btnExit).setOnClickListener {
            finish()
        }
    }

    private fun addItemToArrays() {
        val name = etItemName.text.toString().trim()
        val category = etCategory.text.toString().trim()
        val quantityStr = etQuantity.text.toString().trim()
        val comment = etComments.text.toString().trim()

        if (validateInput(name, category, quantityStr)) {
            try {
                val quantity = quantityStr.toInt()

                // Add to parallel arrays
                itemArray.add(name)
                categoryArray.add(category)
                quantityArray.add(quantity)
                commentArray.add(comment)

                // Clear input fields
                clearInputFields()

                Toast.makeText(this, "Item added successfully", Toast.LENGTH_SHORT).show()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Please enter a valid quantity", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInput(name: String, category: String, quantity: String): Boolean {
        return when {
            name.isEmpty() -> {
                etItemName.error = "Item name required"
                false
            }
            category.isEmpty() -> {
                etCategory.error = "Category required"
                false
            }
            quantity.isEmpty() -> {
                etQuantity.error = "Quantity required"
                false
            }
            else -> true
        }
    }

    private fun clearInputFields() {
        etItemName.text.clear()
        etCategory.text.clear()
        etQuantity.text.clear()
        etComments.text.clear()
        etItemName.clearFocus()
    }

    private fun navigateToListActivity() {
        val intent = Intent(this, Listactivity::class.java).apply {
            putStringArrayListExtra("ITEMS", itemArray)
            putStringArrayListExtra("CATEGORIES", categoryArray)
            putIntegerArrayListExtra("QUANTITIES", ArrayList(quantityArray))
            putStringArrayListExtra("COMMENTS", commentArray)
        }
        startActivity(intent)
    }
}