package com.davidson.criminalintent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

//val simpleDateFormat = SimpleDateFormat("EEEE, LLL dd, yyyy - HH:mm:ss aaa z")

@Entity
data class Crime(
    @PrimaryKey(autoGenerate = false)
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean,
) {
}