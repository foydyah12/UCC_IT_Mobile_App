// Define the package for the application
package com.example.uccitmobileapp

// Data class to represent a course with its attributes
data class CourseModel(
    val code: String,
    val name: String,
    val credits: Int,
    val prerequisites: String,
    val description: String
)
