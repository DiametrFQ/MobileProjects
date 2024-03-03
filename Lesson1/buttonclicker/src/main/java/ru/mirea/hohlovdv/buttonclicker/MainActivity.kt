package ru.mirea.hohlovdv.buttonclicker

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var textViewStudent: TextView
    private lateinit var btnWhoAmI: Button
    private lateinit var btnItIsNotMe: Button
    private lateinit var checkBox: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewStudent = findViewById(R.id.textView)
        btnWhoAmI = findViewById(R.id.button)
        btnItIsNotMe = findViewById(R.id.button2)
        checkBox = findViewById(R.id.checkBox)

        btnWhoAmI.setOnClickListener {
            textViewStudent.text = "Мой номер по списку № 26"
            checkBox.isChecked = true
        }
        btnItIsNotMe.setOnClickListener {
            textViewStudent.text = "Это делал не я"
            checkBox.isChecked = false
        }
    }
}