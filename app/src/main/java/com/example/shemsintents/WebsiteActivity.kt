package com.example.shemsintents

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebsiteActivity : AppCompatActivity() {
    lateinit var myWeb: WebView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_website)
        myWeb = findViewById(R.id.mWeb)
        val webSettings = myWeb.settings
        webSettings.javaScriptEnabled = true
        myWeb.loadUrl( "https://www.emobilis.ac.ke")
    }
}