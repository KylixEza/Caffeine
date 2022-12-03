package com.psi.caffeine.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cafe")
data class Cafe(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cafe_id")
    val cafeId: Int,
    @ColumnInfo(name = "cafe_name")
    val cafeName: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "location")
    val location: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "rating")
    val rating: Double,
    @ColumnInfo(name = "distance")
    val distance: Double,
    @ColumnInfo(name = "open_time")
    val openTime: String,
    @ColumnInfo(name = "close_time")
    val closeTime: String
)
