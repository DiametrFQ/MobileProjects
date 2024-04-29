package ru.mirea.hohlovdv.looper

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import java.util.concurrent.TimeUnit

class MyLoper(
    mainThreadHandler: Handler,
) : Thread() {
    private val TAG = Looper::class.java.simpleName

    lateinit var mHandler: Handler
    private var mainHandler: Handler = mainThreadHandler

    override fun run() {
        Log.d(TAG, "run")
        Looper.prepare()

        fromTaskCode()
        Looper.loop()
    }

    private fun fromTaskCode() {
        mHandler = object : Handler(Looper.myLooper()!!) {
            override fun handleMessage(msg: Message) {

                val startTime = msg.data.getLong("START_TIME")
                val age = msg.data.getInt("AGE")
                val position = msg.data.getString("POSITION")!!

                Log.d("MyLooper get message:", "Возраст: $age.\nКем работаете: $position")

                TimeUnit.MILLISECONDS.sleep(age.toLong())

                val currentTime = System.currentTimeMillis()
                val delay = currentTime - startTime

                val message = Message()
                val bundle = Bundle()

                bundle.putString("result", "New age: $delay")
                message.data = bundle

                mainHandler.sendMessage(message)
            }
        }
    }
}