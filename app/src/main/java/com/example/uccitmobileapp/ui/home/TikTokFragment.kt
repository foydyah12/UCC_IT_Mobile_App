package com.example.uccitmobileapp.ui.home

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.uccitmobileapp.R

//This method is to ensure proper fragment creation
class TikTokFragment : Fragment(R.layout.fragment_tiktok) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val webView: WebView = view.findViewById(R.id.tiktokWebView)
        //To handle loading of the webpage within the app, improve web functionality using Javascript and to load the UCC Tiktok webpages
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.tiktok.com/@uccjamaica")
    }
}

