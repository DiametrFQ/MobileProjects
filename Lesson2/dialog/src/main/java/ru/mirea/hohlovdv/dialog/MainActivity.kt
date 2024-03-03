package ru.mirea.hohlovdv.dialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        val btnTime = findViewById<Button>(R.id.buttonTime)
        val btnProgress = findViewById<Button>(R.id.btnPrgrs)
        val btnData = findViewById<Button>(R.id.buttonData)

        btn.setOnClickListener {
            AlertDialogFragment().show(supportFragmentManager, "mirea")
        }
        btnTime.setOnClickListener {it ->
            onClickShowTimeDialog(it)
        }
        btnProgress.setOnClickListener {it ->
            onClickShowProgressDialog(it)
        }
        btnData.setOnClickListener {it ->
            onClickShowDateDialog(it)
        }
    }

    fun onOkClicked() {
        Toast.makeText(
            applicationContext, "Вы выбрали кнопку \"Иду дальше\"!",
            Toast.LENGTH_LONG
        ).show()
    }

    fun onCancelClicked() {
        Toast.makeText(
            applicationContext, "Вы выбрали кнопку \"Нет\"!",
            Toast.LENGTH_LONG
        ).show()
    }

    fun onNeutralClicked() {
        Toast.makeText(
            applicationContext, "Вы выбрали кнопку \"На паузе\"!",
            Toast.LENGTH_LONG
        ).show()
    }
    /////////////////////////////////////////////////

    private fun onClickShowDateDialog(view: View) =
        MyDateDialogFragment().show(supportFragmentManager, "mirea")

    private fun onClickShowProgressDialog(view: View) =
        MyProgressDialogFragment().show(supportFragmentManager, "mirea")

    private fun onClickShowTimeDialog(view: View) =
        MyTimeDialogFragment().show(supportFragmentManager, "mirea")

    fun callbackTime(view: View, hour: Int, minute: Int) =
        Snackbar.make(findViewById(android.R.id.content), "Time selected: $hour:$minute",
            Snackbar.LENGTH_LONG).show()

    fun callbackDate(view: View, year: Int, month: Int, dayOfMonth: Int) =
        Snackbar.make(findViewById(android.R.id.content), "Date selected: $dayOfMonth.$month.$year",
            Snackbar.LENGTH_LONG).show()

}