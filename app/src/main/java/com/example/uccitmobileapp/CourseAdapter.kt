package com.example.uccitmobileapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//Adapter class for the RecyclerView that displays a list of courses
class CourseAdapter(private val courseList: List<CourseModel>) :
    RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

        //ViewHolder class to hold and bind views for a single item
    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val code: TextView = itemView.findViewById(R.id.txtCourseCode)
        val name: TextView = itemView.findViewById(R.id.txtCourseName)
        val credits: TextView = itemView.findViewById(R.id.txtCourseCredits)
        val prerequisites: TextView = itemView.findViewById(R.id.txtCoursePrerequisites)
        val description: TextView = itemView.findViewById(R.id.txtCourseDescription)
    }
    
// Inflates the layout for each item in the RecyclerView and creates ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    // Binds data from the course list to the views in the ViewHolder
    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]
        holder.code.text = course.code
        holder.name.text = course.name
        holder.credits.text = holder.itemView.context.getString(R.string.credits_format, course.credits)
        holder.prerequisites.text = holder.itemView.context.getString(R.string.prerequisites_format, course.prerequisites)
        holder.description.text = course.description
    }

    override fun getItemCount(): Int = courseList.size
}
