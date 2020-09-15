package com.zeasn.thefirstlinecode.fourthchapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.activity_widget.*

class WidgetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widget)
        supportActionBar?.hide()
        btnMy.setOnClickListener {
            pbMy.progress = pbMy.progress +10
        }
    }

}