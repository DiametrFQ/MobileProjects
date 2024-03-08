package ru.mirea.hohlovdv.sharer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class Pick : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pick)

        val intent = Intent(Intent.ACTION_PICK)
        intent.setType("*/*")

        val callback: ActivityResultCallback<ActivityResult> =
            ActivityResultCallback<ActivityResult> { result ->
                if (result.getResultCode() === RESULT_OK) {
                    val data: Intent? = result.getData()
                    if (data != null) {
                        Log.d(MainActivity::class.java.getSimpleName(), "Data:" + data.dataString)
                    }
                }
            }

        val imageActivityResultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            callback
        )

        imageActivityResultLauncher.launch(intent)
    }
}