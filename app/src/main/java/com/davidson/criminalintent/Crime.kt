package com.davidson.criminalintent

import java.text.SimpleDateFormat
import java.util.Date
import java.util.UUID

val simpleDateFormat = SimpleDateFormat("EEEE, LLL dd, yyyy - HH:mm:ss aaa z")

data class Crime(
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean,
){
    val dateFormatted = simpleDateFormat.format(date)?: "Invalid"

}