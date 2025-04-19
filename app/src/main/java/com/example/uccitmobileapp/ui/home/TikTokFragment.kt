package com.example.uccitmobileapp.ui.home

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.uccitmobileapp.R

class TikTokFragment : Fragment(R.layout.fragment_tiktok) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val webView: WebView = view.findViewById(R.id.tiktokWebView)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.tiktok.com/@uccjamaica")
    }
}

