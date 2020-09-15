package com.zeasn.thefirstlinecode.thirdchapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.activity_life_cycle.*

class LifeCycleActivity : BaseActivity() {
    private val tag = "LifeCycleActivity: "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(tag , this.toString())
        Log.e("first Activity" , "Task id is $taskId")
        setContentView(R.layout.activity_life_cycle)
        //Log.e(tag , "onCreate ")
        btnNormal.setOnClickListener {
            val intent = Intent(this ,MainActivity::class.java)
            startActivity(intent)
        }

        btnDialog.setOnClickListener {
            val intent = Intent(this , DialogActivity::class.java)
            startActivity(intent)
        }

        btnThis.setOnClickListener {
            val intent = Intent(this , LifeCycleActivity::class.java)
            startActivity(intent)
        }
    }

/*
    override fun onStart() {
        super.onStart()
        Log.e(tag , "onStart ")
    }

    override fun onResume() {
        super.onResume()
        Log.e(tag , "onResume ")
    }

    override fun onPause() {
        super.onPause()
        Log.e(tag , "onPause ")
    }

    override fun onStop() {
        super.onStop()
        Log.e(tag , "onStop ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(tag , "onDestroy ")
    }



*/

    override fun onRestart() {
        super.onRestart()
        Log.e(tag , "onRestart ")
    }
}