package com.example.qoutify

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson


class MyViewModel(val context : Context) : ViewModel() {

    private var qouteList : Array<Qoute> = emptyArray()
    private var index = 0

    init {
        qouteList = loadQouteFromAsset()
    }

    private fun loadQouteFromAsset(): Array<Qoute> {

        val inputStream = context.assets.open("quotes.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<Qoute>::class.java)
    }

    fun getQuote() = qouteList[index]

    fun nextQuote() = qouteList[++index]

    fun previouesQoute() = qouteList[--index]
}