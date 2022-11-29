package com.psi.caffeine.model

data class Menu(
    val name: String,
    val price: Int,
    val type: String,
    val image: String,
    val isHalal: Boolean
)
