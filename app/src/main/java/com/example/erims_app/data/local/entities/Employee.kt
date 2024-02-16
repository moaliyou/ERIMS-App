package com.example.erims_app.data.local.entities

data class Employee(
    val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: String,
    val jobTitle: String,
    val salary: Double,
)