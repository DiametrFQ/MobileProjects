package ru.mirea.hohlovdv.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d("listen", "app started!")
    }

    override fun onResume() {
        super.onResume()
        Log.d("listen", "app resumed!")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("listen", "app restarted!")
    }

    override fun onPause() {
        super.onPause()
        Log.d("listen", "app paused!")
    }

    override fun onStop() {
        super.onStop()
        Log.d("listen", "app stoped!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("listen", "app destroyed!")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.d("listen", "app detached from window!")
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.d("listen", "app restore instance state!")
    }

}