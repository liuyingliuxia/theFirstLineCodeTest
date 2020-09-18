package com.zeasn.thefirstlinecode.thirteenth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CounterViewModelFactory(private val countReserved:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CounterViewModel(countReserved ) as T
    }
}