package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ActivityViewModel
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var activityViewModel: ActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activityViewModel = ViewModelProvider(requireActivity()).get(ActivityViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.cancelButton.setOnClickListener{v: View ->
            v.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListingFragment)
        }

        binding.saveButton.setOnClickListener{v: View ->
            var newShoe = Shoe(binding.editTextShoeName.text.toString(), binding.editTextShoeSize.text.toString().toDouble(), binding.editTextCompany.text.toString(),
                binding.editTextDescription.text.toString())
            activityViewModel.addShoe(newShoe)
            Timber.i(activityViewModel.shoeList.value.toString())
            v.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListingFragment)
        }

        return binding.root
    }
}