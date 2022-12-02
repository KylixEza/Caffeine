package com.psi.caffeine.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.psi.caffeine.R
import com.psi.caffeine.data.Dummy
import com.psi.caffeine.model.Cafe

class MainViewModel(
    application: Application
): AndroidViewModel(application) {
    
    private val _promotion = MutableLiveData<List<Int>>()
    val promotion: LiveData<List<Int>> = _promotion
    
    private val _recommendation = MutableLiveData<List<Cafe>>()
    val recommendation: LiveData<List<Cafe>> = _recommendation
    
    private val _closestCafe = MutableLiveData<List<Cafe>>()
    val closestCafe: LiveData<List<Cafe>> = _closestCafe
    
    init {
        _promotion.value = listOf(R.drawable.promotion1, R.drawable.promotion2)
        _recommendation.value = Dummy.recommendationCafe()
        _closestCafe.value = Dummy.getClosestCafe()
    }
    
}