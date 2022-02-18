package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentOnboardingInstructionsBinding

class OnboardingInstructionsFragment: Fragment() {

    private lateinit var binding: FragmentOnboardingInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_onboarding_instructions,
            container,
            false
        )

        binding.shoeListButton.setOnClickListener{ v: View ->
            v.findNavController().navigate(R.id.action_onboardingInstructionsFragment_to_shoeListingFragment)
        }

        return binding.root
    }
}
