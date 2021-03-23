package com.example.task1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var editText  : EditText;
    private lateinit var textView  : TextView;
    private lateinit var addButton : MaterialButton;
    private lateinit var viewButton: MaterialButton;
    private lateinit var nextButton: MaterialButton;

    private val notes = ArrayList<String>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews();
        initListners();
    }

    private fun initListners() {
        addButton.setOnClickListener {
            notes.add(editText.text.toString())
            notes.sort()
            editText.setText("")
            Toast.makeText(this, getString(R.string.motivation_string), Toast.LENGTH_LONG).show()
        }

        viewButton.setOnClickListener {
            textView.text = ""
            for (item in notes)
                textView.append(item + "\n")
            Toast.makeText(this, getString(R.string.motivation_string2), Toast.LENGTH_LONG).show()
        }

        nextButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initViews() {
        editText = findViewById(R.id.edit_text_name)
        addButton = findViewById(R.id.button_add)
        textView = findViewById(R.id.text_view_presenter)
        viewButton = findViewById(R.id.button_view)
        nextButton = findViewById(R.id.button_next)
    }
}
