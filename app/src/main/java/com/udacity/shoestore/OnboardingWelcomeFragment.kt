package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentOnboardingWelcomeBinding

class OnboardingWelcomeFragment: Fragment() {

    private lateinit var binding: FragmentOnboardingWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding_welcome, container, false)

        binding.instructionsButton.setOnClickListener { v: View ->
            v.findNavController().navigate(OnboardingWelcomeFragmentDirections.actionOnboardingWelcomeFragmentToOnboardingInstructionsFragment())
        }

        return binding.root
    }
}