package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cs4520.assignment3.databinding.HomeFragmentLayoutBinding

class HomeFragment: Fragment() {
    private var _binding: HomeFragmentLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentLayoutBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mvpButton.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_MVPFragment)
        }
        binding.mvvmButton.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_MVVMFragment)
        }
    }

}