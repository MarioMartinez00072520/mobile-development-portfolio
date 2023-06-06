package com.example.laboratorio05.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class MovieModel (
    val movieId: Int,
    val name: String,
    val category: String,
    val description: String,
    val qualification: String,
)
{
    // TODO: add constructor
}