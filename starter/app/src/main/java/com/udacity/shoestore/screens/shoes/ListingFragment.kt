package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.databinding.ShoeDetailsBinding
import com.udacity.shoestore.models.Shoe

class ListingFragment : Fragment() {

    private val viewModel: ListingViewModel by activityViewModels() // https://developer.android.com/topic/libraries/architecture/viewmodel#sharing
    private lateinit var binding: FragmentListingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_listing, container, false)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newShoeList ->
                   updateShoeList(inflater, container, newShoeList)
        })


        //checked https://www.geeksforgeeks.org/floating-action-button-fab-in-android-with-example/
        binding.addFab.setOnClickListener{
            findNavController().navigate(ListingFragmentDirections.actionListingFragmentToDetailFragment())
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.listing_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.loginFragment ->{
                findNavController().navigate(ListingFragmentDirections.actionListingFragmentToLogout())
            }
        }
        return  super.onOptionsItemSelected(item)
    }

    private fun updateShoeList(inflater: LayoutInflater, container: ViewGroup?, shoesList: List<Shoe>) {
        val shoesLayout =
            binding.root.findViewById<LinearLayout>(R.id.shoesLinear)
        shoesList.forEach { shoe ->
            val shoeDetailsBinding =
                DataBindingUtil.inflate<ShoeDetailsBinding>(inflater, R.layout.shoe_details, container, false)
            shoeDetailsBinding.shoe = shoe
            shoesLayout.addView(shoeDetailsBinding.root)
        }
    }
}