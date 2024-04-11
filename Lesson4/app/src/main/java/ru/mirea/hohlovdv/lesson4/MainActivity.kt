package ru.mirea.hohlovdv.lesson4

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.mirea.hohlovdv.lesson4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.getRoot())

        binding!!.editTextMirea.setText("Мой номер по списку №27")
        binding!!.buttonMirea.setOnClickListener {
            Log.d(
                MainActivity::class.java.getSimpleName(),
                "onClickListener"
            )
        }
    }
}