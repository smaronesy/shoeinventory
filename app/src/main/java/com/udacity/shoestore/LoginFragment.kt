package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment: Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.login.setOnClickListener { v: View ->
            navigateToWelcomeScren(v)
        }

        binding.signup.setOnClickListener { v: View ->
            navigateToWelcomeScren(v)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    fun navigateToWelcomeScren(view: View){
        view.findNavController().navigate(R.id.action_loginFragment_to_onboardingWelcomeFragment)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}