package com.zeasn.thefirstlinecode.sixth

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.activity_broadcast_test.*

class BroadcastTestActivity : AppCompatActivity() {
    lateinit var timeChangeReceiver: TimeChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_test)

        btnSendBroadcast.setOnClickListener {
            val intent = Intent(".MY_BROADCAST")
            intent.setPackage(packageName)
            //发送标准广播
            //sendBroadcast(intent)
            //发送有序广播
            sendOrderedBroadcast(intent , null )
        }

        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        intentFilter.addAction("android.intent.action.SCREEN_OFF")
        intentFilter.addAction("android.intent.action.SCREEN_ON")
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver , intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    inner class TimeChangeReceiver():BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent) {
            Log.e("BroadCastTestActivity" , "Time has changed")
            Toast.makeText(context , "Something has changed" ,Toast.LENGTH_SHORT).show()
        }
    }
}