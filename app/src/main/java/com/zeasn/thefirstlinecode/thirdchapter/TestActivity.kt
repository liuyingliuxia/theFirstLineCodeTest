package com.zeasn.thefirstlinecode.thirdchapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("Third Activity" , "Task id is $taskId")
        setContentView(R.layout.activity_test)
        btnBack.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_return" , "Hello this TestActivity")
            setResult(RESULT_OK , intent )
            finish()
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return" , "你按了返回键哦")
        setResult(RESULT_OK , intent )
        finish()

    }
}