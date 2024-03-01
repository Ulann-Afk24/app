package com.example.navigations.nav_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigations.R
import com.example.navigations.databinding.FragmentLoginBinding
import com.example.navigations.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        binding.tvToLogin.setOnClickListener {
           findNavController().navigate(R.id.action_registerFragment_to_loginFragment5)
        }

        binding.buttonRegister.setOnClickListener{
            findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
        }
        return binding.root
    }
}