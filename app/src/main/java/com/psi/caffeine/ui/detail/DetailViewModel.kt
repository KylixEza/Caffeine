package com.psi.caffeine.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.psi.caffeine.data.Dummy
import com.psi.caffeine.model.Cafe
import com.psi.caffeine.model.Comment
import com.psi.caffeine.model.Menu

class DetailViewModel: ViewModel() {
    
    private val _menuList = MutableLiveData<List<Menu>>()
    val menuList: LiveData<List<Menu>> = _menuList
    
    private val _detailCafe = MutableLiveData<Cafe>()
    val detailCafe: LiveData<Cafe> = _detailCafe
    
    private val _comments = MutableLiveData<List<Comment>>()
    val comments: LiveData<List<Comment>> = _comments
    
    fun setDetailCafe(cafeId: String) {
        _detailCafe.value = Dummy.getDetailCafe(cafeId)
    }
    
    init {
    
    }
}