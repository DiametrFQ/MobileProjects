package ru.mirea.hohlovdv.favoritebook

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ShareActivity : AppCompatActivity() {
    private lateinit var textUserFavoriteBook: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        textUserFavoriteBook = findViewById(R.id.editTextText)

        var textViewDevBook : TextView = findViewById(R.id.textView)
        var btn :Button = findViewById(R.id.button2)

        btn.setOnClickListener{ onBtnSendClick() }

        val extras = intent.extras
        if (extras!= null) {
            val textBook = extras.getString(MainActivity.KEY)
            textViewDevBook.text = "Developer`s favorite book - $textBook"
        }
    }

    fun onBtnSendClick() {
        val data = Intent()
        data.putExtra(MainActivity.USER_MESSAGE, textUserFavoriteBook.text.toString())
        setResult(RESULT_OK, data)
        finish()
    }
}