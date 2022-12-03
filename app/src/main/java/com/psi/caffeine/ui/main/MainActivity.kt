package com.psi.caffeine.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.psi.caffeine.R
import com.psi.caffeine.adapter.ClosestCafeAdapter
import com.psi.caffeine.adapter.PromotionAdapter
import com.psi.caffeine.adapter.RecommendationCafeAdapter
import com.psi.caffeine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        
        val promotionAdapter = PromotionAdapter()
        val recommendationAdapter = RecommendationCafeAdapter()
        val closestCafeAdapter = ClosestCafeAdapter()
    
        binding.apply {
            rvPromotion.adapter = promotionAdapter
            rvPromotion.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        
            rvRecommendation.adapter = recommendationAdapter
            rvRecommendation.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        
            rvClosestCafe.adapter = closestCafeAdapter
            rvClosestCafe.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    
        viewModel.promotion.observe(this) {
            promotionAdapter.submitList(it)
        }
        
        viewModel.recommendation.observe(this) {
            recommendationAdapter.submitList(it)
        }
        
        viewModel.closestCafe.observe(this) {
            closestCafeAdapter.submitList(it)
        }
    }
}