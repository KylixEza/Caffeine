package com.psi.caffeine.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Menu(
    val menuId: String,
    val name: String,
    val price: Int,
    val type: String,
    val image: String,
    val isHalal: Boolean
)
