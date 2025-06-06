package com.example.uccitmobileapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// This class is a helper for managing the database of UCC courses.
class DBHelper(context: Context) : SQLiteOpenHelper(context, "ucc_courses.db", null, 2) {

    //Name of the table storing course information
    private val tableCourses = "courses"

    // This method is called when the database is created and to create courses table
    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE IF NOT EXISTS $tableCourses (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                code TEXT,
                name TEXT,
                credits INTEGER,
                prerequisites TEXT,
                description TEXT
            )
        """.trimIndent()

        // Execute the SQL statement to create the table
        db.execSQL(createTable)

        // Populate the table with the initial course data
        insertInitialCourses(db)
    }

    // Inserts courses data into the course table
    private fun insertInitialCourses(db: SQLiteDatabase) {
        val courses = listOf(
            CourseModel("ITT101", "Intro to IT", 3, "None", "An introductory course covering the fundamental principles, components, and operations of information technology systems."),
            CourseModel("ITT102", "Programming 1", 3, "None", "A beginner-friendly course that introduces the basics of computer programming using Kotlin, focusing on syntax, logic, and problem-solving."),
            CourseModel("ITT201", "Networking", 3, "ITT101", "Covers the foundational concepts of computer networking including protocols, network devices, and data transmission."),
            CourseModel("ITT202", "Databases", 3, "ITT102", "Introduces relational databases, SQL programming, and data modeling techniques for organizing and managing structured data."),
            CourseModel("ITT203", "Web Design", 3, "ITT102", "Focuses on designing and developing responsive websites using HTML, CSS, and JavaScript, with emphasis on user experience and accessibility."),
            CourseModel("ITT301", "Mobile Dev", 4, "ITT203", "Explores mobile app development using Kotlin for Android, covering user interfaces, activities, and app functionality."),
            CourseModel("ITT302", "Cybersecurity", 3, "ITT201", "Examines the principles of digital security, including threats, vulnerabilities, cryptography, and secure network practices."),
            CourseModel("ITT303", "Discrete Math", 3, "None", "Covers foundational mathematical concepts used in computing, such as logic, sets, functions, relations, and proofs."),
            CourseModel("ITT304", "Data Structures", 3, "ITT102", "Teaches essential data structures such as arrays, linked lists, stacks, queues, trees, and their use in algorithm development."),
            CourseModel("ITT305", "Cloud Computing", 3, "ITT202", "Introduces cloud computing concepts, service models, and platforms, including deployment and management of cloud resources.")
        )

        //Loop through the lists aof courses and to insert into the database
        for (course in courses) {
            val values = ContentValues().apply {
                put("code", course.code)
                put("name", course.name)
                put("credits", course.credits)
                put("prerequisites", course.prerequisites)
                put("description", course.description)
            }
            db.insert(tableCourses, null, values)
        }
    }

    // This method calls the database when it upgrades to the new version
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $tableCourses")
        onCreate(db)
    }

    //Retrieves all courses from the database and returns them as a list of CourseModel objects
    fun getAllCourses(): List<CourseModel> {
        val courseList = mutableListOf<CourseModel>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $tableCourses", null)

        //Check if the cursor contains any rows
        if (cursor.moveToFirst()) {
            do {
                val code = cursor.getString(cursor.getColumnIndexOrThrow("code"))
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                val credits = cursor.getInt(cursor.getColumnIndexOrThrow("credits"))
                val prereqs = cursor.getString(cursor.getColumnIndexOrThrow("prerequisites"))
                val description = cursor.getString(cursor.getColumnIndexOrThrow("description"))

                //Add the course to the list
                courseList.add(CourseModel(code, name, credits, prereqs, description))
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return courseList
    }
}
