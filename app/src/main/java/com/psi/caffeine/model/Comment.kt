package com.psi.caffeine.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Comment(
    val commentId: String,
    val username: String,
    val comment: String,
)
