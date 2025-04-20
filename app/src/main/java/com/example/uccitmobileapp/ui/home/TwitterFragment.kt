package com.example.uccitmobileapp.ui.home

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.uccitmobileapp.R

//This method is to ensure proper fragment creation 
class TwitterFragment : Fragment(R.layout.fragment_twitter) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val webView: WebView = view.findViewById(R.id.twitterWebView)
        //To handle webpage within the app instead of browser, for a better web functionality using Javascript and to load UCC Twitter webpage
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://twitter.com/uccjamaica")
    }
}

