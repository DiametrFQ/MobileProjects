package ru.mirea.hohlovdv.lesson3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val number = 27.0
        val squereOfNumber = number.pow(2).toInt()
        val message = intent.getStringExtra("message")
        val text = "КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ ${squereOfNumber}, а текущее время ${message}"

        val textView = findViewById<TextView>(R.id.textView2)
        textView.text = text
    }
}