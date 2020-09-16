package com.zeasn.thefirstlinecode.seventh

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.activity_sp.*

class SpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)
        btnSave.setOnClickListener {
            val editor = getSharedPreferences("data" , Context.MODE_PRIVATE).edit()
            editor.putString("name","Miracle")
            editor.putInt("age" , 22)
            editor.putBoolean("single" , false )
            editor.apply()
            Toast.makeText(this ,"数据已保存",Toast.LENGTH_SHORT).show()
        }

        btnRestore.setOnClickListener {
            val prefs = getSharedPreferences("data" , Context.MODE_PRIVATE)
            val name = prefs.getString("name" , "")
            val age = prefs.getInt("age" , 0 )
            val single = prefs.getBoolean("single" , false)
            Log.d("SpActivity" , "name is $name")
            Log.d("SpActivity" , "age is $age")
            Log.d("SpActivity" , "isSingle is $single")
        }
    }
}