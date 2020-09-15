package com.zeasn.thefirstlinecode.sixth

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * author : Miracle.lin
 * time   : 2020/09/15
 * desc   :
 * e-mail : miracle.lin@zeasn.com
 */
class BootCompleteReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context , "开机完成！", Toast.LENGTH_SHORT).show()
    }

}