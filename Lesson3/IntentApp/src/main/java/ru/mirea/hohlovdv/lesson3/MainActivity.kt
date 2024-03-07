package ru.mirea.hohlovdv.lesson3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val dateInMillis = System.currentTimeMillis()
        val format = "yyyy-MM-dd HH:mm:ss"
        val sdf = SimpleDateFormat(format)
        val dateString: String = sdf.format(Date(dateInMillis))

        val intent = Intent(this, MainActivity2::class.java)
        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            intent.putExtra("message", dateString)
            startActivity(intent)
        }
    }
}