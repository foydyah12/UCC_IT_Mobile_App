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

class AdmissionsFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_admission, container, false)

        val applyLink = view.findViewById<TextView>(R.id.applicationLink)
        val applyLinks = view.findViewById<TextView>(R.id.internationalLink)

        applyLink.setOnClickListener {
            val url = "https://ucc.edu.jm/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        applyLinks.setOnClickListener {
            val url = "https://ucc.edu.jm/programmes/undergraduate/requirements-for-international-students"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        return view
    }
}
