package com.zeasn.thefirstlinecode.tenth

import android.app.IntentService
import android.content.Intent
import android.widget.Toast

class MyIntentService :IntentService("MyIntentService"){
    override fun onHandleIntent(intent: Intent?) {
        Toast.makeText(this, "Thread is ${Thread.currentThread().name}", Toast.LENGTH_LONG)
            .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy executed", Toast.LENGTH_LONG)
            .show()
    }
}