package com.example.crud_mvvm.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo (
    val title: String,
    val description:String?,
    val isDone: Boolean,
    @PrimaryKey val id: Int? = null //Room will create an id for us
)