package com.udacity.shoestore.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init{
        _shoeList.value = mutableListOf()
        addDummyData()
    }

     fun addShoe(shoe: Shoe){
        _shoeList.value?.add(shoe)
    }

    private fun addDummyData(){
        addShoe(Shoe("Superstar", 6.5, "Adidas", "Popular urban shoes"))
        addShoe(Shoe("Running", 7.5, "Nike", "Good running shoes"))
    }
}