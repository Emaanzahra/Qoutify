package com.example.qoutify

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel


class ViewModelFactory(val context : Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(context) as T
    }
}