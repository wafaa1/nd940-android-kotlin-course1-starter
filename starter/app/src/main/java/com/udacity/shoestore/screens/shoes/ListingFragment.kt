package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.screens.welcome.WelcomeFragmentDirections

class ListingFragment : Fragment() {

    private lateinit var viewModel: ListingViewModel

    private lateinit var binding: FragmentListingBinding

    private var listSize = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_listing, container, false)

        // Get the viewmodel
        viewModel = ViewModelProvider(this).get(ListingViewModel::class.java)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newList ->
           // TODO
        })

        viewModel.eventShoeAdded.observe(viewLifecycleOwner, Observer { hasAddedShoe ->
            if(hasAddedShoe) {
                listTheShoes()
            }
        })

        binding.addButton.setOnClickListener{
            findNavController().navigate(ListingFragmentDirections.actionListingFragmentToDetailFragment())
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    private fun listTheShoes(){
/*        //  example for adding a button to linearlayout programatically
        buttonAddView.setOnClickListener {
            val button = Button(this)
            button.text = "This is Button"
            linear_layout.addView(button)
        }
    }
}
*/
    }
}
