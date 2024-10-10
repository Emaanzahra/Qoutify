package com.example.qoutify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainviewmodel : MyViewModel

    private val qouteText : TextView
        get() = findViewById(R.id.qouteText)

    private val qouteAuthor : TextView
        get() = findViewById(R.id.qouteAuthor)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainviewmodel = ViewModelProvider(this, ViewModelFactory(application)).get(MyViewModel::class.java)
        setQuote(mainviewmodel.getQuote())
    }

    fun setQuote(quote : Qoute){
        qouteText.text = quote.text
        qouteAuthor.text = quote.author

    }

    fun onPrevious(view: View) {
        setQuote(mainviewmodel.previouesQoute())
    }
    fun onNext(view: View) {
        setQuote(mainviewmodel.nextQuote())
    }
    fun onShare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, mainviewmodel.getQuote().text)
        startActivity(intent)
    }
}