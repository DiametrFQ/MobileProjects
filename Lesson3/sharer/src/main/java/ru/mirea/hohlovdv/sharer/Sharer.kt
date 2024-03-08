package ru.mirea.hohlovdv.sharer

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Sharer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sharer)

        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("*/*")
        intent.putExtra(Intent.EXTRA_TEXT, "Mirea")
        startActivity(Intent.createChooser(intent, "Выбор за вами!"))
    }
}