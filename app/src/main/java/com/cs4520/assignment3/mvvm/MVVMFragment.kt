package com.cs4520.assignment3.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.databinding.MvvmLayoutBinding

// the view
class MVVMFragment : Fragment() {
    private var _binding: MvvmLayoutBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MVVMViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = MvvmLayoutBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this).get(MVVMViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        fragmentResultUpdateObserver()
    }

    private fun setupClickListeners() {
        binding.addButton.setOnClickListener {
            try {
                viewModel.executeOperation(binding.inputNumber1.text.toString().toDouble(),
                    binding.inputNumber2.text.toString().toDouble(),
                    "+")
            } catch (e: Exception) {
                displayToast("Invalid operation")
            }
            clearInput()
        }
        binding.subtractButton.setOnClickListener {
            try {
                viewModel.executeOperation(binding.inputNumber1.text.toString().toDouble(),
                    binding.inputNumber2.text.toString().toDouble(),
                    "-")
            } catch (e: Exception) {
                displayToast("Invalid operation")
            }
            clearInput()
        }
        binding.multiplyButton.setOnClickListener {
            try {
                viewModel.executeOperation(binding.inputNumber1.text.toString().toDouble(),
                    binding.inputNumber2.text.toString().toDouble(),
                    "*")
            } catch (e: Exception) {
                displayToast("Invalid operation")
            }
            clearInput()
        }
        binding.divideButton.setOnClickListener {
            try {
                if (binding.inputNumber2.text.toString().toDouble() == 0.0) {
                    displayToast("Cannot divide by zero!")
                }
                viewModel.executeOperation(binding.inputNumber1.text.toString().toDouble(),
                    binding.inputNumber2.text.toString().toDouble(),
                    "/")
            } catch (e: Exception) {
                displayToast("Invalid operation")
            }
            clearInput()
        }
    }

    private fun fragmentResultUpdateObserver() {
        viewModel.result.observe(viewLifecycleOwner) {result ->
            binding.resultTextView.text = result.toString()
        }
    }

    private fun displayToast(message: String) {
        // display toast message
        Toast.makeText(this.activity, message,
            Toast.LENGTH_SHORT).show();
    }

    private fun clearInput() {
        // to make input numbers blank
        binding.inputNumber1.text.clear()
        binding.inputNumber2.text.clear()
    }
}


