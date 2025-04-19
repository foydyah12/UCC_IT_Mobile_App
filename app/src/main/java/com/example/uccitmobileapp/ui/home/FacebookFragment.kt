package com.example.uccitmobileapp.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uccitmobileapp.R

class FacebookFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        openFacebookPage()
        return inflater.inflate(R.layout.fragment_facebook, container, false)
    }

    private fun openFacebookPage() {
        val facebookUrl = "https://www.facebook.com/uccjamaica"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl))
        startActivity(intent)
    }
}


