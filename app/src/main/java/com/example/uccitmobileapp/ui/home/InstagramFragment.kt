package com.example.uccitmobileapp.ui.home

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.uccitmobileapp.R

//This fragment represnts an Instagram page and loads it inside a WebView
class InstagramFragment : Fragment(R.layout.fragment_instagram) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val webView: WebView = view.findViewById(R.id.instagramWebView)
        //Sets a WebViewClient to handle the loading of the web pages within the app, JavaScript for better web functionality and to load the UCC webpage
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.instagram.com/uccjamaica/")
    }
}
