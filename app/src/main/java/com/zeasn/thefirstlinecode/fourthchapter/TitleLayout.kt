package com.zeasn.thefirstlinecode.fourthchapter

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.title.view.*
import java.util.jar.Attributes

/**
 * author : Miracle.lin
 * time   : 2020/09/14
 * desc   :自定义标题控件
 * e-mail : miracle.lin@zeasn.com
 */

class TitleLayout (context: Context , attrs:AttributeSet) :LinearLayout(context ,attrs ){
    init {
        LayoutInflater.from(context).inflate(R.layout.title,this)
        btnBack.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
        btnEdit.setOnClickListener {
            repeat(5){
                Log.e(" 点击了5次" ,it.toString() )
            }
            Toast.makeText(context , "编辑",Toast.LENGTH_SHORT).show()

        }
    }
}