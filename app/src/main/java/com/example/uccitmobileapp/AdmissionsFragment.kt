package com.example.uccitmobileapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

// this defines the admissionsfragment
class AdmissionsFragment : Fragment() {
    
    //Suppress lint warning for missing ID
    @SuppressLint("MissingInflatedId")

    //This defines the Fragment's UI
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_admission, container, false)
        
 //TextView element with ID 'applicationLink' and assign it
        val applyLink = view.findViewById<TextView>(R.id.applicationLink)
        val applyLinks = view.findViewById<TextView>(R.id.internationalLink)

        // Set an OnClickListener on 'applyLink' to open the UCC website
        applyLink.setOnClickListener {
            val url = "https://ucc.edu.jm/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

         // Set an OnClickListener on 'applyLinks' to open the international students requirements page
        applyLinks.setOnClickListener {
            val url = "https://ucc.edu.jm/programmes/undergraduate/requirements-for-international-students"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        return view
    }
}
