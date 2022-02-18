package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.viewmodels.ActivityViewModel
import kotlinx.android.synthetic.main.fragment_shoe_listing.view.*
import timber.log.Timber

class ShoeListingFragment: Fragment() {

    private lateinit var binding: FragmentShoeListingBinding
    lateinit var activityViewModel: ActivityViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activityViewModel = ViewModelProvider(requireActivity()).get(ActivityViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)

        binding.floatingActionButton.setOnClickListener { v: View ->
            v.findNavController().navigate(R.id.action_shoeListingFragment_to_shoeDetailFragment)
        }

        activityViewModel.shoeList.observe(viewLifecycleOwner, Observer {
            Timber.i(activityViewModel.shoeList.value.toString())
            for(shoe in it!!) {
                var border = TextView(context)
                border.text = "-----------------------------------------------------"
                binding.shoeList.addView(border)
                var newShoe= TextView(context)
                newShoe.text = shoe.name  + "  |  " +  shoe.company + "  |  " + shoe.size + "  |  " + shoe.description
                binding.shoeList.addView(newShoe)
            }
        })

        return binding.root
    }
}