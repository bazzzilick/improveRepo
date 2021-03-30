package com.example.task1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import android.widget.Toast.makeText as makeText1


class SecondActivity : AppCompatActivity() {

    private lateinit var editText: EditText;
    private lateinit var textView: TextView;
    private lateinit var viewButton: MaterialButton;

    private val students = HashMap<Int, Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initViews()
        initListners()
    }

    private fun initListners() {
        editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                var parts = editText.text.toString().split(" ")
                if (parts.size != 4) {
                    Toast.makeText(this, getString(R.string.invalid_input), Toast.LENGTH_LONG).show()
                } else {
                    var student = Student(parts[0], parts[1], parts[2], parts[3])
                    students[student.id] = student
                    Toast.makeText(this, getString(R.string.data_complete), Toast.LENGTH_LONG).show()
                }
                editText.setText("")
                true
            }
            false
        })

        viewButton.setOnClickListener {
            textView.text = ""
            for (it in students)
                textView.append(it.key.toString() + " " + it.value.name + " " + it.value.surName
                        + " " + it.value.grade + " " + it.value.birthdayYear + "\n")
            makeText1(this, getString(R.string.view_complete), Toast.LENGTH_LONG).show()
        }

    }

    private fun initViews() {
        editText = findViewById(R.id.edit_text_students_data)
        textView = findViewById(R.id.students_data_view_presenter)
        viewButton = findViewById(R.id.button_view_students_data)
    }
}
