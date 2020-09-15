package com.zeasn.thefirstlinecode.thirdchapter

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * author : Miracle.lin
 * time   : 2020/09/14
 * desc   :
 * e-mail : miracle.lin@zeasn.com
 */
open class BaseActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("BaseActivity" , javaClass.simpleName)
    }
}