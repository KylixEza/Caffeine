package com.psi.caffeine.model

data class Cafe(
    val cafeId: String,
    val cafeName: String,
    val description: String,
    val location: String,
    val image: Int,
    val rating: Double,
    val distance: Double,
    val openTime: String,
    val closeTime: String
)
