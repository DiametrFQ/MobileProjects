package ru.mirea.hohlovdv.sharer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var btnSharer = findViewById<Button>(R.id.btnSharer)
        btnSharer.setOnClickListener{
            startActivity (Intent(this, Sharer::class.java))
        }
        var btnPick = findViewById<Button>(R.id.btnPick)
        btnPick.setOnClickListener{
            startActivityForResult(Intent(this, Pick::class.java) , 200)
        }

    }
}