package ru.mirea.hohlovdv.intentfilter

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val address = Uri.parse("https://www.mirea.ru/")
            val openLinkIntent = Intent(Intent.ACTION_VIEW, address)
            startActivity(openLinkIntent)
        }

        val btn2 = findViewById<Button>(R.id.button2)
        btn2.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "ХОХЛОВ ДМИТРИЙ ВЛАДИМИРОВИЧ");
            startActivity(Intent.createChooser(shareIntent, "МОИ ФИО"));
        }
    }
}