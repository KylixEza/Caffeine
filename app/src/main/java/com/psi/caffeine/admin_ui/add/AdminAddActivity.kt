package com.psi.caffeine.admin_ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.psi.caffeine.R
import com.psi.caffeine.databinding.ActivityAdminAddBinding
import com.psi.caffeine.model.Cafe
import kotlin.math.absoluteValue
import kotlin.random.Random

class AdminAddActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityAdminAddBinding
    private lateinit var viewModel: AdminAddViewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        viewModel = ViewModelProvider(this)[AdminAddViewModel::class.java]
        
        binding.btnCreate.setOnClickListener {
            val decimalFormat = java.text.DecimalFormat("#.#")
            decimalFormat.roundingMode = java.math.RoundingMode.FLOOR
            val cafe = Cafe(
                cafeName = binding.tilName.text.toString(),
                description = binding.tilDescription.text.toString(),
                location = "Jl Raya Kopo",
                image = "",
                rating = decimalFormat.format(Random.nextDouble(4.0, 5.0)).toDouble(),
                distance = decimalFormat.format(Random.nextDouble(0.1, 5.0)).toDouble(),
                openTime = "08:00",
                closeTime = "23:00"
            )
            viewModel.insertCafe(cafe)
            finish()
        }
    }
}