package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private val viewModel: ListingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_detail, container, false)

        binding.saveButton.setOnClickListener{
            viewModel.addShoe(getShoeDetails())
            findNavController().navigateUp()
        }

        binding.cancelButton.setOnClickListener{
            findNavController().navigateUp()
        }

        return binding.root
    }

    private fun getShoeDetails() : Shoe {
        var shoe : Shoe = Shoe("",0.0,"", "")
        shoe.name = binding.editShoeName.text.toString()
        shoe.size = binding.editShoeSize.text.toString().toDouble()
        shoe.company = binding.editShoeCompany.text.toString()
        shoe.description = binding.editShoeDescription.text.toString()
        return shoe
    }
}