package com.zeasn.thefirstlinecode.tenth

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity() {
    lateinit var downloadBinder: MyService.MyBinder

    private val connection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            downloadBinder = service as MyService.MyBinder
            downloadBinder.startDownload()
            downloadBinder.getProgress()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        btnStart.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent)
        }

        btnStop.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
        }

        btnBind.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }

        btnUnbind.setOnClickListener {
            unbindService(connection)

        }
        //IntentService 已被废弃
        btnStartIntentService.setOnClickListener {
            Toast.makeText(this, "Thread is ${Thread.currentThread().name}", Toast.LENGTH_LONG)
                .show()
            val intent = Intent(this, ServiceActivity::class.java)
            startService(intent)
        }

    }
}