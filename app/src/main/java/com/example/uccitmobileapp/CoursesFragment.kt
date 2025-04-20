package com.example.uccitmobileapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//Fragments class to display list of courses using a RecycleViewer
class CoursesFragment : Fragment() {

    // Declare variables to hold references to the various files
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CourseAdapter
    private lateinit var dbHelper: DBHelper
    private lateinit var courseList: List<CourseModel>

    //To create and return to the hierarchy linked with the fragments
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_courses, container, false)

        //Initialize the RecyclerView from the layout and its manager
        recyclerView = view.findViewById(R.id.recyclerViewCourses)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //Initialize the database helper and retrieve the list of all courses
        dbHelper = DBHelper(requireContext())
        courseList = dbHelper.getAllCourses()

        //Initialize the adapter with the course list
        adapter = CourseAdapter(courseList)
        recyclerView.adapter = adapter

        return view
    }
}
