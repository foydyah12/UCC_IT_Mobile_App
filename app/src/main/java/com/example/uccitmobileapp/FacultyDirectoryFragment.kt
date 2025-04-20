package com.example.uccitmobileapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FacultyDirectoryFragment : Fragment() {

    //Variables for the RecyclerView for the Faculty Adapter and the list of faculty members
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FacultyAdapter
    private lateinit var facultyList: List<FacultyModel>

    //This method is used to setup the fragment's user interface
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_faculty_directory, container, false)

        //Initialize the RecyclerView and set the layout manager
        recyclerView = view.findViewById(R.id.recyclerViewFaculty)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //To populate the facultyList with instances of FacultyModel containing their details
        facultyList = listOf(
            FacultyModel("Dr. Jane Smith", "jane@ucc.edu.jm", "876-675-1234", R.drawable.pfp_icon),
            FacultyModel("Mr. John Brown", "john@ucc.edu.jm", "876-555-5678", R.drawable.pfp_icon),
            FacultyModel("Ms. Diana James", "diana@ucc.edu.jm", "876-836-9273", R.drawable.pfp_icon),
            FacultyModel("Mr. Peter Love", "peter@ucc.edu.jm", "876-555-5678", R.drawable.pfp_icon),
            FacultyModel("Mrs. Jae Elliot", "jae@ucc.edu.jm", "876-325-9760", R.drawable.pfp_icon),
            FacultyModel("Dr. Kemar Thompson", "kemar@ucc.edu.jm", "876-456-2178", R.drawable.pfp_icon),
            FacultyModel("Ms. Alicia Grant", "alicia@ucc.edu.jm", "876-622-9703", R.drawable.pfp_icon),
            FacultyModel("Mr. Dwayne Richards", "dwayne@ucc.edu.jm", "876-773-6348", R.drawable.pfp_icon),
            FacultyModel("Mr. Andre Morgan", "andre@ucc.edu.jm", "876-312-4490", R.drawable.pfp_icon),
            FacultyModel("Mrs. Natalie Sinclair", "natalie@ucc.edu.jm", "876-205-1403", R.drawable.pfp_icon),
            FacultyModel("Dr. Omar Bailey", "omar@ucc.edu.jm", "876-735-8253", R.drawable.pfp_icon),
            FacultyModel("Mrs. Tiffany Blake", "tiffany@ucc.edu.jm", "876-584-0059", R.drawable.pfp_icon),
            FacultyModel("Ms. Latoya Campbell", "latoya@ucc.edu.jm", "876-593-9306", R.drawable.pfp_icon),
            FacultyModel("Dr. Shanice Brown", "shanice@ucc.edu.jm", "876-456-7821", R.drawable.pfp_icon),
            FacultyModel("Dr. Trina McDonald", "trina@ucc.edu.jm", "876-342-8765", R.drawable.pfp_icon),
            FacultyModel("Mr. Ricardo Green", "richard@ucc.edu.jm", "876-713-8723", R.drawable.pfp_icon),
            FacultyModel("Dr. Malia George-Brown", "malia@ucc.edu.jm", "876-654-0987", R.drawable.pfp_icon),
            FacultyModel("Mr. Otis Osbourne", "otis@ucc.edu.jm", "876-562-8467", R.drawable.pfp_icon),
            FacultyModel("Ms. Janine Howard", "janine@ucc.edu.jm", "876-786-3456", R.drawable.pfp_icon),
            FacultyModel("Ms. Ava McKitty", "ava@ucc.edu.jm", "876-980-8746", R.drawable.pfp_icon),




        )

        //To display the faculty list
        adapter = FacultyAdapter(facultyList)
        recyclerView.adapter = adapter

        return view
    }
}
