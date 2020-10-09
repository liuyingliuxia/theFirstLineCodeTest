package com.zeasn.thefirstlinecode.thirteenth

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.activity_counter.*

class CounterActivity : AppCompatActivity() {
    lateinit var viewModel: CounterViewModel
    lateinit var sp: SharedPreferences

    //lateinit var observer: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycle.addObserver(MyObserver())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        lifecycle.addObserver(MyObserver())
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        viewModel = ViewModelProvider(this, CounterViewModelFactory(countReserved))
            .get(CounterViewModel::class.java)
        // viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
        fabPlus1.setOnClickListener {
            viewModel.plusOne()
            // refreshCounter()
        }

        clearBtn.setOnClickListener {
            viewModel.clear()
        }
        // refreshCounter()

        viewModel.counter.observe(this, Observer { count ->
            infoText.text = count.toString()
        })
    }

    /* override fun onStart() {
         super.onStart()
         observer.activityStart()
     }

     override fun onStop() {
         super.onStop()
         observer.activityStop()
     }*/

    private fun refreshCounter() {
        infoText.text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved", viewModel.counter.value ?: 0)
        }
    }
}