package com.psi.caffeine.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comment")
data class Comment(
    @PrimaryKey
    @ColumnInfo(name = "comment_id")
    val commentId: String,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "comment")
    val comment: String,
)
