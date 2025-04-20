package com.example.uccitmobileapp.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uccitmobileapp.R

//THis fragment represents a Facebook page and automatically oprns it when the fragment is created
class FacebookFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Opens the Facebook page as soon as the fragment's view is created
        openFacebookPage()
        return inflater.inflate(R.layout.fragment_facebook, container, false)
    }

    //This function launches an intent to open the specified Facebook page in a browser or app
    private fun openFacebookPage() {
        val facebookUrl = "https://www.facebook.com/uccjamaica"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl))
        startActivity(intent)
    }
}


