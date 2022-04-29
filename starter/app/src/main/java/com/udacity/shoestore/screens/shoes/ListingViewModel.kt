package com.udacity.shoestore.screens.shoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ListingViewModel : ViewModel() {

    //internal
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    //external
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    private  val  initialShoeList = mutableListOf<Shoe>(
            Shoe("runner",10.0,"nike","men sports shoes for running"),
            Shoe("tennis", 8.5 , "puma", "ladies sports tennis shoes"),
            Shoe("classic", 11.5, "clarks", "men classic black shoes")
    )

    init{
        _shoeList.value = mutableListOf()
        startList()
    }

    private fun startList() {
        initialShoeList.forEach { shoe: Shoe ->
            addShoe(shoe)
        }
    }

    fun addShoe(shoe: Shoe){
        _shoeList.value?.add(shoe)
    }
}

