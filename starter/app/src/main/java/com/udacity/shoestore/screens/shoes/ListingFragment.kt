package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.databinding.ShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.welcome.WelcomeFragmentDirections

class ListingFragment : Fragment() {

//    private lateinit var viewModel: ListingViewModel

    private val viewModel: ListingViewModel by activityViewModels()
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
        return  NavigationUI.onNavDestinationSelected(item,requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

    private fun updateShoeList(inflater: LayoutInflater, container: ViewGroup?, shoesList: List<Shoe>) {
        val shoesLayout =
            binding.root.findViewById<LinearLayout>(R.id.shoesLinear)//maybe for resolving scrolling shoeDetailsLayout?
        shoesList.forEach { shoe ->
            val shoeDetailsBinding =
                DataBindingUtil.inflate<ShoeDetailsBinding>(inflater, R.layout.shoe_details, container, false)
            shoeDetailsBinding.shoe = shoe
            shoesLayout.addView(shoeDetailsBinding.root)
        }
    }
}