package com.psi.caffeine.model

data class Cafe(
    val cafeId: String,
    val title: String,
    val description: String,
    val location: String,
    val image: String,
    val rating: Double,
    val distance: Double
)
