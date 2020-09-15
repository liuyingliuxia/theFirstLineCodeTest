package com.zeasn.thefirstlinecode.thirdchapter

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zeasn.thefirstlinecode.sixth.LoginActivity

/**
 * author : Miracle.lin
 * time   : 2020/09/14
 * desc   :
 * e-mail : miracle.lin@zeasn.com
 */
open class BaseActivity :AppCompatActivity(){
    lateinit var receiver :ForceOfflineReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("BaseActivity" , javaClass.simpleName)
        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction(".FORCE_OFFLINE")
        receiver = ForceOfflineReceiver()
        registerReceiver(receiver , intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    inner class ForceOfflineReceiver:BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            AlertDialog.Builder(context).apply {
                setTitle("Warning")
                setMessage("You are forced to be offline. Please try to login again.")
                setCancelable(false)
                setPositiveButton("OK") { _, _ ->
                    ActivityCollector.finishAll() // 销毁所有Activity
                    val i = Intent(context, LoginActivity::class.java)
                    context?.startActivity(i) // 重新启动LoginActivity
                }
                show()
            }
        }

    }
}