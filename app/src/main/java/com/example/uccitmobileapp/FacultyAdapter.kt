package com.example.uccitmobileapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//Adapter for managing the display of faculty members in RecyclerView
class FacultyAdapter(private val facultyList: List<FacultyModel>) :
    RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder>() {
        
//ViewHolder class to define the components of a single item view for a faculty member
    inner class FacultyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val facultyImage: ImageView = itemView.findViewById(R.id.imgFaculty)
        val facultyName: TextView = itemView.findViewById(R.id.txtFacultyName)
        val facultyEmail: TextView = itemView.findViewById(R.id.txtFacultyEmail)
        val facultyPhone: TextView = itemView.findViewById(R.id.txtFacultyPhone)
    }

    //This method is called to create a new ViewHOlder object for an item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_faculty, parent, false)
        return FacultyViewHolder(view)
    }

    //This method binds the data to the ViewHolder for a specific position in the RecyclerView
    override fun onBindViewHolder(holder: FacultyViewHolder, position: Int) {
        val faculty = facultyList[position]
        holder.facultyName.text = faculty.name
        holder.facultyEmail.text = faculty.email
        holder.facultyPhone.text = faculty.phone
        holder.facultyImage.setImageResource(faculty.imageResId)

// Add click listener to initiate a phone call  when the phone number is clicked
        holder.facultyPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${faculty.phone}")
            it.context.startActivity(intent)
        }

// Add click listener to compose an email when the email address is clicked
        holder.facultyEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${faculty.email}")
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = facultyList.size
}
