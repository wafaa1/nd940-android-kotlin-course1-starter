package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.databinding.ShoeDetailsBinding
import com.udacity.shoestore.screens.welcome.WelcomeFragmentDirections

class ListingFragment : Fragment() {

    private lateinit var viewModel: ListingViewModel

    private lateinit var binding: FragmentListingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_listing, container, false)

        // Get the viewmodel
        viewModel = ViewModelProvider(this).get(ListingViewModel::class.java)

        //is this needed?
        binding.lifecycleOwner = viewLifecycleOwner



// look example here https://stackoverflow.com/questions/2395769/how-to-programmatically-add-views-to-views
        binding.addFab.setOnClickListener{
            findNavController().navigate(ListingFragmentDirections.actionListingFragmentToDetailFragment())
        }

        viewModel.eventShoeAdded.observe(viewLifecycleOwner, Observer { hasAddedShoe ->
            if(hasAddedShoe) {
//                updateShoeList()
                val shoesLayout = binding.root.findViewById<LinearLayout>(R.id.shoesLinear)

                viewModel.shoeList.value?.forEach { shoe ->
                    val tempBinding = DataBindingUtil.inflate<ShoeDetailsBinding>(inflater, R.layout.shoe_details, container, false)
                    tempBinding.shoe = shoe
                    shoesLayout.addView(tempBinding.root)
                }

                viewModel.gotTheAddedShoe()
            }
        })

        setHasOptionsMenu(true)


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    private fun updateShoeList(){

    }
}

//        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newList ->
//        val iterator = newList.listIterator()
//        for (item in iterator) {
//        // add view}
//           // TODO
//        })
/*
viewModel.eventShoeAdded.observe(viewLifecycleOwner, Observer { hasAddedShoe ->
    if(hasAddedShoe) {
//                updateShoeList()
    }
})*/







