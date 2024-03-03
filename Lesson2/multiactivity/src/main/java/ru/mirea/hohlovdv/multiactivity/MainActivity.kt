package ru.mirea.hohlovdv.multiactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickNewActivity(view: View?) {
//        val intent = Intent(this, Second_Activity::class.java)
//        startActivity(intent)

//        val intent = Intent(
//            this@MainActivity,
//            Second_Activity::class.java
//        )
//        intent.putExtra("key", "MIREA - Хохлов Дмитрий Владимирович СТУДЕНТА")
//        startActivity(intent)
//
//        // У второй активности
//        val text = getIntent().getSerializableExtra("key") as String?

        val ET = findViewById<EditText>(R.id.editText1)
        val btn = findViewById<Button>(R.id.button)

        val intent = Intent(
            this@MainActivity,
            MainActivity2::class.java
        )

//        intent.putExtra("key", "MIREA - Хохлов Дмитрий Владимирович СТУДЕНТА")
//        startActivity(intent)

        btn.setOnClickListener {
            intent.putExtra("key", ET.text.toString())
            startActivity(intent)
            setContentView(R.layout.activity_main2)
        }
    }
}