package com.psi.caffeine.data

import com.psi.caffeine.R
import com.psi.caffeine.model.Cafe

object Dummy {
    
    fun recommendationCafe() = listOf<Cafe>(
        Cafe(
            "CAFE001",
            "Kopi Kenangan",
            " Kopi Kenangan adalah perusahaan yang bergerak di bidang kopi minuman yang turut meramaikan pasar kopi kekinian di Indonesia.",
            "Jl Citra Niaga Raya",
            R.drawable.kopi_kenangan,
            4.5,
            0.5,
            "08:00",
            "21:00"
        ),
        Cafe(
            "CAFE002",
            "Eight Coffee",
            "Eight Coffee adalah perusahaan yang bergerak di bidang kopi minuman yang turut meramaikan pasar kopi kekinian di Indonesia.",
            "Jl Veteran Raya",
            R.drawable.eight_cooffee,
            4.5,
            1.2,
            "06:00",
            "20:00"
        ),
        Cafe(
            "CAFE003",
            "Handall",
            "Handall adalah perusahaan yang bergerak di bidang kopi minuman yang turut meramaikan pasar kopi kekinian di Indonesia.",
            "Jl Intan Raya",
            R.drawable.handall,
            4.5,
            0.5,
            "06:00",
            "20:00"
        ),
        Cafe(
            "CAFE004",
            "Lab Coffee",
            "Lab Coffee adalah perusahaan yang bergerak di bidang kopi minuman yang turut meramaikan pasar kopi kekinian di Indonesia.",
            "Jl sisingamaraja",
            R.drawable.lab_coffee,
            4.8,
            0.4,
            "06:00",
            "19:00"
        ),
        Cafe(
            "CAFE005",
            "Kopi Soe",
            "Kopi Soe adalah perusahaan yang bergerak di bidang kopi minuman yang turut meramaikan pasar kopi kekinian di Indonesia.",
            "Jl Kalpataru Ekse",
            R.drawable.kopi_soe,
            4.2,
            0.1,
            "10:00",
            "18:00"
        ),
    )
    
    fun getClosestCafe() = listOf(
        Cafe(
            "CAFE006",
            "Kurang Lebih",
            "Kurang Lebih adalah perusahaan yang bergerak di bidang kopi minuman yang turut meramaikan pasar kopi kekinian di Indonesia.",
            "Jl MT Haryono",
            R.drawable.kurang_lebih,
            4.5,
            1.2,
            "06:00",
            "20:00"
        ),
        Cafe(
            "CAFE007",
            "Starbucks Coffee",
            "Starbucks Coffee adalah perusahaan yang bergerak di bidang kopi minuman yang turut meramaikan pasar kopi kekinian di Indonesia.",
            "Jl Sisingamaraja",
            R.drawable.starbucks_coffee,
            4.5,
            1.5,
            "09:00",
            "22:00"
        ),
        Cafe(
            "CAFE008",
            "Subway",
            "Subway adalah perusahaan yang bergerak di bidang kopi minuman yang turut meramaikan pasar kopi kekinian di Indonesia.",
            "Jl Belimbing",
            R.drawable.subway,
            4.5,
            1.7,
            "07:00",
            "22:00"
        )
    )
    
    fun getDetailCafe(cafeId: String) = run {
        val cafes = recommendationCafe() + getClosestCafe()
        cafes.find { it.cafeId == cafeId }
    }
}