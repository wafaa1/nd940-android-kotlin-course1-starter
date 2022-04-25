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

    //to keep track when a new shoe is added
    private val _eventShoeAdded=MutableLiveData<Boolean>()
    //external
    val eventShoeAdded : LiveData<Boolean>
        get()=_eventShoeAdded


    init{
        startList()
        _eventShoeAdded.value = false
    }

    private fun startList() {
        _shoeList.value = mutableListOf<Shoe>(
            Shoe("runner",10.0,"nike","men sports shoes for running"),
            Shoe("tennis", 8.5 , "puma", "ladies sports tennis shoes"),
            Shoe("classic", 11.5, "clarks", "men classic black shoes")
        )
    }
}