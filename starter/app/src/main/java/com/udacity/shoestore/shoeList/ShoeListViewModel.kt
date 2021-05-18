package com.udacity.shoestore.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _shoeToAdd = MutableLiveData<Shoe>()
    val shoeToAdd: LiveData<Shoe>
        get() = _shoeToAdd

    init{
        _shoeList.value = mutableListOf()
        _shoeToAdd.value = Shoe("", 0.0, "", "")
        addDummyData()
    }

    fun addShoe(){
        _shoeList.value?.add(shoeToAdd.value!!)
    }

    private fun addDummyData(){
        _shoeList.value?.add(Shoe("Superstar", 6.5, "Adidas", "Popular urban shoes"))
        _shoeList.value?.add(Shoe("Running", 7.5, "Nike", "Good running shoes"))
    }
}