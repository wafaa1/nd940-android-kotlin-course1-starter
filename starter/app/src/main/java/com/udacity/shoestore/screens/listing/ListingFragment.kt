package com.udacity.shoestore.screens.listing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListingBinding

class ListingFragment : Fragment() {

    private lateinit var binding: FragmentListingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_listing, container, false)

        return binding.root
    }
}
/*
Hint: In the Shoe List destination, to add a child view programmatically to a ViewGroup, such as LinearLayout,
use the addView() method https://developer.android.com/reference/kotlin/android/view/ViewGroup.html#addview .
Refer to a sample implementation in the StackOverflow discussion here:
https://stackoverflow.com/questions/2395769/how-to-programmatically-add-views-to-views.
 */