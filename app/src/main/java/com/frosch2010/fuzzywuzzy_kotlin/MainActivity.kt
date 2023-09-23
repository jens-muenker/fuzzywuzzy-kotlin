package com.frosch2010.fuzzywuzzy_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCompare = findViewById<Button>(R.id.buttonCompare)
        val editOne = findViewById<TextView>(R.id.editText)
        val editTwo = findViewById<TextView>(R.id.editText2)

        buttonCompare.setOnClickListener {
            if(editOne.text.isEmpty() || editTwo.text.isEmpty()) {
                Toast.makeText(this, "Please enter text in both fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val ratio = FuzzySearch.ratio(editOne.text.toString(), editTwo.text.toString())
            Toast.makeText(this, "Ratio: $ratio", Toast.LENGTH_SHORT).show()
        }
    }
}