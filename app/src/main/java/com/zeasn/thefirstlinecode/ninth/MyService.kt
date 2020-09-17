package com.zeasn.thefirstlinecode.ninth

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.zeasn.thefirstlinecode.R

const val TAG = "MyService!!!------------->"

class MyService : Service() {

    private val mBinder = MyBinder()

    class MyBinder : Binder() {
        fun startDownload() {
            Log.e(TAG, "startDownload executed")
        }

        fun getProgress(): Int {
            Log.e(TAG, "getProgress executed")
            return 0
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, "onCreate Service ")
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as 
                NotificationManager
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O) {
            val channel = NotificationChannel("my_service" , "前台通知服务",
            NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }

        val intent = Intent(this , ServiceActivity::class.java)
        val pi = PendingIntent.getActivity(this , 0, intent ,0 )
        val notification = NotificationCompat.Builder(this , "my_service")
            .setContentTitle("标题")
            .setContentText("内容-------------------")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_background))
            .setContentIntent(pi)
            .build()
        startForeground(1, notification )
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("MyService", "onStartCommand Service ")
        return super.onStartCommand(intent, flags, startId)

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MyService", "onDestroy Service ")
    }
}
